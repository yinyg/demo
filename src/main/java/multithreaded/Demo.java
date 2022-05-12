package multithreaded;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yinyg
 * @date 2022/5/11
 */
public class Demo {

    private static Logger log = LoggerFactory.getLogger(Demo.class);

    private Lock lock;
    private Condition condition;

    private int num = 0;

    public Demo() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    /**
     * @throws
     * @description interrupt() demo
     * @author yinyg
     * @date 2022/5/11
     */
    @Test
    public void interruptedExceptionDemo() {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("---interrupted---");
            }
            System.out.println("---end---");
        });
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();
        t.interrupt();
    }

    /**
     * @throws
     * @description Thread.UncaughtExceptionHandler demo
     * @author yinyg
     * @date 2022/5/11
     */
    @Test
    public void uncaughtExceptionDemo() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(e.getMessage());
            }
        };
        Thread t = new Thread(() -> {
//            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
//            Thread.currentThread().setUncaughtExceptionHandler(uncaughtExceptionHandler);
            throw new RuntimeException("uncaughtException message");
        });
        t.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();
    }

    /**
     * @throws
     * @description 条件对象Condition demo
     * @author yinyg
     * @date 2022/5/11
     */
    @Test
    public void conditionDemo() {
        Thread t = new Thread(() -> {
            Thread.currentThread().setName("thread-0");
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "开始执行");
                while (num <= 0) {
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + "执行结束");
            } catch (InterruptedException e) {
                Thread.interrupted();
            } finally {
                lock.unlock();
            }
        });
        Thread t1 = new Thread(() -> {
            Thread.currentThread().setName("thread-1");
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "开始执行");
                num++;
                System.out.println(Thread.currentThread().getName() + "执行结束");
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        });
        try {
            t.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();
        t1.start();
    }

    /**
     * @throws
     * @description Future demo
     * @author yinyg
     * @date 2022/5/11
     */
    @Test
    public void futureDemo() {
        log.info("started ScheduledFuture");
        Runnable r = () -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Runnable demo");
        };
        Thread rt = new Thread(r);
        try {
            rt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rt.start();
        Callable<String> c = () -> {
            Thread.sleep(20000L);
            return "Callable demo";
        };
        FutureTask<String> cf = new FutureTask(c);
        Thread ft = new Thread(cf);
        ft.start();
        try {
            log.info(cf.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws
     * @description ExecutorService invokeAny、invokeAll返回null或者抛出异常demo
     * invokeAny如果
     * @author yinyg
     * @date 2022/5/11
     */
    @Test
    public void executorServiceInvokeDemo() throws ExecutionException, InterruptedException {
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(() -> {
            Thread.currentThread().setName("thread-0");
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 1000L) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.printf("%s canceled%n", Thread.currentThread().getName());
                    return null;
                }
            }
            return 10;
        });
        tasks.add(() -> {
            Thread.currentThread().setName("thread-1");
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 2000L) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.printf("%s canceled%n", Thread.currentThread().getName());
                    return null;
                }
            }
            return 20;
        });
//        tasks.add(() -> {
//            Thread.currentThread().setName("thread-2");
//            return null;
//        });
        tasks.add(() -> {
            Thread.currentThread().setName("thread-3");
            throw new NoSuchElementException();
        });
        ExecutorService executor = Executors.newCachedThreadPool();
        Integer invokeAny = executor.invokeAny(tasks);
        System.out.printf("invokeAny: %d%n", invokeAny);
        List<Future<Integer>> invokeAll = executor.invokeAll(tasks);
        Integer invokeAllSum = 0;
        if (invokeAll != null && invokeAll.size() > 0) {
            invokeAllSum = invokeAll.stream()
                    .map(f -> {
                        Integer result = null;
                        try {
                            result = f.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return result != null ? result : 0;
                    })
                    .reduce(invokeAllSum, Integer::sum);
        }
        System.out.printf("invokeAllSum: %d", invokeAllSum);
    }

    /**
     * @throws
     * @description CompletableFuture demo
     * @author yinyg
     * @date 2022/5/11
     */
    @Test
    public void completableFutureDemo() {
        CompletableFuture c = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("supplyAsync");
            return "from supplyAsync";
        })
        .thenApply(v -> {
            log.info(v);
            return "from thenApply";
        })
        .thenCompose(v -> {
            log.info(v);
            return CompletableFuture.supplyAsync(() -> "from thenCompose");
        })
        .thenAccept(v -> {log.info(v);})
        .thenApplyAsync(v -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "from thenApply";
        });
        log.info("--------------------");
        try {
            log.info(c.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

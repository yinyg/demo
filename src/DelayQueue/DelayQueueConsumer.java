package DelayQueue;

import java.util.Random;
import java.util.concurrent.DelayQueue;

/**
 * @author yinyg
 * @date 2020/9/1
 * @description
 */
public class DelayQueueConsumer implements Runnable {
    private DelayQueue<DelayMessage> delayQueue = new DelayQueue<>();

    public DelayQueueConsumer(DelayQueue delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                DelayMessage message = this.delayQueue.take();
                System.out.println("consume message: " + message.getMessage()
                        + ", ttl: " + message.getTtl()
                        + ", current: " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DelayQueue<DelayMessage> delayQueue = new DelayQueue();
        new Thread(new DelayQueueConsumer(delayQueue)).start();
        for (int i = 0; i < 10; ++i) {
            int ttl = new Random().nextInt(10);
            delayQueue.offer(new DelayMessage("message " + i, 1000 * ttl));
        }
    }
}

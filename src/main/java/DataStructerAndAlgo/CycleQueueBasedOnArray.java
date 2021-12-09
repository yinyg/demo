package DataStructerAndAlgo;

/**
 * @Author yinyg
 * @CreateTime 2020/6/23 16:47
 * @Description 基于数组实现的循环队列
 */
public class CycleQueueBasedOnArray {
    // size-数组容量，head-队头，tail-队尾
    int size = 0, head = 0, tail = 0;

    Integer[] items;

    public CycleQueueBasedOnArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size must general then 0");
        }
        items = new Integer[size];
        this.size = size;
    }

    public boolean enqueue(Integer item) {
        if ((tail + 1) % size ==  head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % size;
        return true;
    }

    public Integer dequeue() {
        if (head == tail) {
            return null;
        }
        Integer item = items[head];
        head = (head + 1) % size;
        return item;
    }

    public void printAll() {
        int i = head;
        System.out.print("queue: ");
        while (i != tail) {
            System.out.print(items[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CycleQueueBasedOnArray queue = new CycleQueueBasedOnArray(6);
        queue.printAll();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.printAll();
        queue.dequeue();
        queue.dequeue();
        queue.printAll();
        queue.enqueue(0);
        queue.enqueue(1);
//        queue.enqueue(2);
        queue.printAll();
    }
}

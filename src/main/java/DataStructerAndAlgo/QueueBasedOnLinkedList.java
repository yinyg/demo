package DataStructerAndAlgo;

/**
 * @Author yinyg
 * @CreateTime 2020/6/23 14:41
 * @Description 基于链表实现队列4
 */
public class QueueBasedOnLinkedList {
    // 队头head，队尾tail
    Node head = null;
    Node tail = null;

    public void enqueue(int item) {
        Node newNode = new Node(item, null);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        }  else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public Integer dequeue() {
        if (head == null) {
            return null;
        }
        Integer item = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return item;
    }

    public static class Node {
        Node next;
        Integer value;

        public Node(Integer value, Node next) {
            this.next = next;
            this.value = value;
        }
    }

    public static Node createNodeList(int size) {
        Node soldier = new Node(null, null);
        Node p = soldier;
        int i = 0;
        while (i < size) {
            p.next = new Node(i, null);
            p = p.next;
            i++;
        }
        return p.next;
    }

    public static void printAll(Node nodeList) {
        Node node = nodeList;
        System.out.print("nodeList: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        QueueBasedOnLinkedList.printAll(queue.head);
        queue.dequeue();
        queue.dequeue();
        QueueBasedOnLinkedList.printAll(queue.head);
    }
}

package DataStructerAndAlgo;

/**
 * @Author yinyg
 * @CreateTime 2020/6/17 14:39
 * @Description 链表相关算法
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 */
public class LinkedListAlgo {
    public static void main(String[] args) {
//        // 1) 单链表反转
//        Node origin = LinkedListAlgo.createNodeList(6);
//        System.out.print("orinin: ");
//        LinkedListAlgo.printAll(origin);
//        Node reverse = LinkedListAlgo.reverse(origin);
//        System.out.print("reverse: ");
//        LinkedListAlgo.printAll(reverse);

//        // 2) 链表中环的检测
//        Node nodeList = LinkedListAlgo.createNodeList(6);
//        Node node6 = new Node(6, null);
//        nodeList.next = node6;
//        Node node7 = new Node(7, null);
//        node6.next = node7;
//        Node node8 = new Node(8, null);
//        node7.next = node8;
//        node8.next = node6;
//        boolean checkCircle = LinkedListAlgo.checkCircle(nodeList);
//        System.out.println("checkCircle: " + checkCircle);

//        // 3) 两个有序的链表合并
//        Node l1 = LinkedListAlgo.createNodeList(3);
//        Node l2 = LinkedListAlgo.createNodeList(6);
//        System.out.print("l1: ");
//        LinkedListAlgo.printAll(l1);
//        System.out.print("l2: ");
//        LinkedListAlgo.printAll(l2);
//        Node result = LinkedListAlgo.mergeTwoLists(l1, l2);
//        System.out.print("result: ");
//        LinkedListAlgo.printAll(result);

//        // 4) 删除链表倒数第n个结点
//        Node origin = LinkedListAlgo.createNodeList(8);
//        System.out.print("origin: ");
//        LinkedListAlgo.printAll(origin);
//        Node result = LinkedListAlgo.deleteLastKth(origin, 3);
//        System.out.print("result: ");
//        LinkedListAlgo.printAll(result);

        // 5) 求链表的中间结点
        Node nodeList = LinkedListAlgo.createNodeList(6);
        LinkedListAlgo.printAll(nodeList);
        Node middleNode = LinkedListAlgo.findMiddleNode(nodeList);
        System.out.println("middle node: " + middleNode.value);
    }

    /**
     * 单链表反转
     * @param nodeList
     * @return
     */
    public static Node reverse(Node nodeList) {
        Node cur = nodeList, pre = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 链表中环的检测
     * @param nodeList
     * @return
     */
    public static boolean checkCircle(Node nodeList) {
        if (nodeList != null) {
            Node slow = nodeList, fast = nodeList.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 两个有序的链表合并
     * 适用条件：已知的两个链表都是从小到大排序
     * @param l1
     * @param l2
     * @return
     */
    public static Node mergeTwoLists(Node l1, Node l2) {
        Node soldier = new Node(0, null); // 利用哨兵结点简化实现难度
        Node p = soldier;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else if (l2 != null) {
            p.next = l2;
        }
        return soldier.next;
    }

    /**
     * 删除倒数第K个结点
     * @param nodeList
     * @param k
     * @return
     */
    public static Node deleteLastKth(Node nodeList, int k) {
        Node fast = nodeList;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            i++;
        }
        if (fast == null) {
            return nodeList;
        }
        Node slow = nodeList;
        Node pre = null;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre == null) {
            nodeList = nodeList.next;
        } else {
            pre.next = pre.next.next;
        }
        return nodeList;
    }

    /**
     * 求链表的中间结点
     * @param nodeList
     * @return
     */
    public static Node findMiddleNode(Node nodeList) {
        if (nodeList == null) {
            throw new IllegalArgumentException("nodeList can not be null");
        }
        Node slow = nodeList, fast = nodeList;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static class Node {
        Node next;

        int value;

        public Node(int value, Node next) {
            this.next = next;
            this.value = value;
        }
    }

    public static Node createNodeList(int size) {
        Node first = new Node(0, null);
        Node last = first;
        int i = 1;
        while (i < size) {
            last.next = new Node(i, null);
            last = last.next;
            i++;
        }
        return first;
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
}

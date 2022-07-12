package DataStructerAndAlgo;

/**
 * @Author yinyg
 * @CreateTime 2020/6/22 16:45
 * @Description
 */
public class LinkedListStack {
    private Node top = null;

    public void push(int item) {
        Node newNode = new Node(item, null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null) {
            return -1;
        }
        int item = top.value;
        top = top.next;
        return item;
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

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        LinkedListStack.printAll(stack.top);
        stack.pop();
        LinkedListStack.printAll(stack.top);
        stack.pop();
        stack.pop();
        LinkedListStack.printAll(stack.top);
    }
}

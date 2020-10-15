package queue;

public class MyQueue<E> {

    private Node<E> head = null;
    private Node<E> tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void put(E data) {
        Node<E> newNode = new Node<E>(data);
        if (head == null && tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public E pop() {
        if (this.isEmpty())
            return null;
        E data = head.data;
        head = head.next;
        return data;
    }

    public int size() {
        Node<E> tmp = head;
        int n = 0;
        while (tmp != null) {
            n++;
            tmp = tmp.next;
        }
        return n;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.put(1);
        queue.put(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

}

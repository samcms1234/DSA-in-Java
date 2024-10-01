import java.util.NoSuchElementException;

public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        front = null;
        rear = null;
        length = 0;
    }

    public int length() {
        return this.length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int first() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return front.data;
    }

    public int last() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return rear.data; 
    }

    public void enqueue(int data) {
        ListNode ln = new ListNode(data);

        if(isEmpty()) {
            front = ln;
        } else {
            rear.next = ln;
        }
        rear = ln;
        length++;
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        int result = front.data;
        front = front.next;
        if(front == null) {
            rear = null;
        }

        length--;
        return result;
    }

    public void print() {

        if(isEmpty()) {
            return;
        }
        ListNode current = front;
        while(current != null) {
            System.out.print(current.data + "--->");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);


        queue.enqueue(4);

    }
}

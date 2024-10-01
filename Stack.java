import java.util.EmptyStackException;

public class Stack {
    private ListNode top;
    private int length;

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        this.top = null;
        this.length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int data) {
        ListNode ln = new ListNode(data);
        ln.next = top;
        top = ln;
        length++;
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        int res = top.data;
        top = top.next;
        return res;
    }

    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    public static void main(String[] args) {
        Stack st = new Stack();

        st.push(10);
        st.push(11);
        st.push(12);

        System.out.println(st.top.data);

    }
}

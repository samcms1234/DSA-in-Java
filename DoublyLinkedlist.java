public class DoublyLinkedlist {
    private ListNode head;
    private ListNode tail;
    private int length;

    private static class ListNode {
        private ListNode previous;
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedlist() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void fDisplay() {
        ListNode temp = head;

        while(temp != null) {
            System.out.print(temp.data + "--->");
            temp = temp.next;
        }

        System.out.print("null");
    }

    public void bDisplay() {
        ListNode temp = tail;

        while(temp != null) {
            System.out.print(temp.data + "--->");
            temp = temp.previous;
        }

        System.out.print("null");
    }

    public void addNodeAtBegining(int val) {
        ListNode ln = new ListNode(val);

        if(isEmpty()) {
            tail = ln;
        }
        else {
            head.previous = ln;
        }

        ln.next = head;
        head = ln;
        length++;
        fDisplay();
    }

    public void addNodeAtTheEnd(int data) {
        ListNode ln = new ListNode(data);

        if(isEmpty()) {
            head = ln;
        }
        else {
            tail.next = ln;
        }

        ln.previous = tail;
        tail = ln;

        fDisplay();
        bDisplay();
    }

    public ListNode removeNodeFromTheEnd() {
        if(isEmpty() || length == 1) {
            return head;
        }
        else {
            ListNode last = tail;
            tail = tail.previous;
            tail.next = null;
            return last;
        }
    }

    public static void main(String args[]) {
        DoublyLinkedlist dl = new DoublyLinkedlist();

        ListNode first = new ListNode(0);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(3);

        dl.head = first;
        dl.tail = fourth;

        first.previous = null;
        first.next = second;
        second.previous = first;
        second.next = third;
        third.previous = second;
        third.next = fourth;
        fourth.previous = third;
        fourth.next = null;

        dl.length = 4;

        // dl.addNodeAtBegining(9);
        dl.addNodeAtTheEnd(10);
        dl.removeNodeFromTheEnd();
    }
}

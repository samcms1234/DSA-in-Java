public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode ln) {
            this.val = val;
            this.next = ln;
        } 
    }

    public void display() {
        ListNode current = head;

        while(current != null) {
            System.out.print(current.val+ "--->");
            current = current.next;
        }
        System.out.print("null");
    }

    public void reverse() {

        SinglyLinkedList sn = new SinglyLinkedList();
        sn.head = null;

        ListNode current = head;

        while(current != null) {
            ListNode temp = new ListNode(current.val);
            temp.next = sn.head;
            sn.head = temp;
            current = current.next;
        }

        sn.display();
    }

    // Add a node to the begining of the linkedList

    public void addNodeToBegining(int value) {
        ListNode ln = new ListNode(value);

        ln.next = head;
        head = ln;

        display();
    }

    // Add a Node to the end of the linkedlist

    public void addNodeAtEnd(int value) {
        ListNode ln = new ListNode(value);

        if(head == null) {
            head = ln;
            return;
        }

        ListNode current = head;

        while(current.next != null) {
            current = current.next;
        }

        current.next = ln;

        display();

    }

    public void addTwoNumbers(SinglyLinkedList s1, SinglyLinkedList s2) {
        
    }

    public void oddEvenList() {
        SinglyLinkedList s1 = new SinglyLinkedList();
        SinglyLinkedList s2 = new SinglyLinkedList();

        s1.head = null;
        s2.head = null;

        ListNode current = head;
        int count = 1;

        while(current != null) {
            if(count%2 == 0) {
                ListNode temp = new ListNode(current.val, null);
                temp.next = s2.head;
                s2.head = temp;
            }
            else {
                ListNode temp = new ListNode(current.val, null);
                temp.next = s1.head;
                s1.head = temp;
            }

            count++;
            current = current.next;
        }

        s1.display();
        s2.display();
    }

    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();

        sl.head = new ListNode(0);

        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(4);

        sl.head.next = second;
        second.next = third;
        third.next = fourth;

        sl.display();
        sl.addNodeAtEnd(12);
        sl.addNodeToBegining(1);

        // sl.reverse();

        // sl.oddEvenList();
    }
}
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

    // Add a node at any position in a linkedlist

    public void addNumberAtPosN(int position, int value) {
        ListNode ln = new ListNode(value);
        if(position == 1) {
            ln.next = head;
            head = ln;
        }
        else {
            ListNode previous = head;
            int i = 1;

            while(i < position - 1) {
                previous = previous.next;
                i++;
            }

            ListNode current = previous.next;
            previous.next = ln;
            ln.next = current;

        }

        display();
    }

    // Delete a node at the start

    public ListNode deleteFirstNode() {
        if(head == null) {
            return null;
        }

        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    // Delete a node at the end of the linkedlist

    public int removeLastElement() {
        if(head == null || head.next == null) {
            return head.val;
        }
        else {
            ListNode current = head;
            ListNode previous = null;

            while(current.next != null) {
                previous = current;
                current = current.next;
            }

            previous.next = null;
            return current.val;
        }
    }

    public void deleteNodeAtNPosition(int position) {
        if(position == 1) {
            head = head.next;
        }
        else {
            ListNode previous = head;
            int count = 1;

            while(count < position-1) {
                previous = previous.next;
                count++;
            }

            ListNode current = previous.next;
            previous.next = current.next;
        }

        display();
    }

    // Delete all elements with a value

    public void deleteAllElementsWithAValue(int value) {
        if(head == null) {
            System.out.println(head);
        }
        else {
            ListNode current = head;
            ListNode previous = null;

            while(current != null) {

                if(current.val == value) {
                    ListNode ln = current;
                    current = current.next;
                    previous.next = ln.next;
                    ln.next = null;
                }
                else {
                    previous = previous.next;
                    current = current.next;
                }  
                System.out.println(current.val);
            } 
        }
    }

    // Add a Node to sorted Linkedl

    public ListNode addNumber(ListNode ll) {
        if(head == null) {
            display();
            return ll;
        }
        else if(head.val >= ll.val) {
            ll.next = head;
            head = ll;
            display();
            return head;
        }
        else {
            ListNode current = head;
            ListNode temp = null;

            while(current != null && current.val < ll.val) {
                temp = current;
                current = current.next;
            }

            ll.next = current;
            temp.next = ll;
            display();
            return head;
        }
    }

    public ListNode removeduplicates() {
        if(head == null || head.next == null) {
            display();
            return head;
        }
        else {
            ListNode current = head;

            while(current != null && current.next != null) {
                if(current.val == current.next.val) {
                    current.next = current.next.next;
                }
                else {
                    current = current.next;
                }
            }
            display();
            return head;
        }
    }

    public void addTwoNumbers(SinglyLinkedList s1, SinglyLinkedList s2) {
        
    }

    public ListNode SelectionSort(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;

        while(current != null) {
            ListNode i = current.next;
            ListNode temp = current;

            while(i != null) {
                if(i.val < temp.val) {
                    temp = i;
                }
                i = i.next;
            }

            if(temp != null && temp.val < current.val) {
                int t = current.val;
                current.val = temp.val;
                temp.val = t;
            }
            current = current.next;
        }
        return head;
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
        // sl.addNodeAtEnd(12);
        // sl.addNodeToBegining(1);

        // sl.reverse();

        // sl.oddEvenList();
        // sl.addNumberAtPosN(3, 25);

        // System.out.println(sl.deleteFirstNode().val);
        // sl.deleteAllElementsWithAValue(1);
        // sl.deleteNodeAtNPosition(4);
        ListNode ll = new ListNode(4);
        sl.addNumber(ll);
        sl.removeduplicates();
    }
}
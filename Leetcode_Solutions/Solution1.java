package Leetcode_Solutions;

// Remove Duplicates from Sorted List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int index = lengthOfLL(head) - n + 1;
        return deleteNodeAtNIndex(head, index);
    }

    public ListNode deleteNodeAtNIndex(ListNode head, int index) {
        if(index == 1) {
            head = head.next;
            return head;
        }

        int position = 1;
        ListNode previous = head;

        while(position < index -1) {
            previous = previous.next;
            position++;
        }

        ListNode current = previous.next;
        previous.next = current.next;
        current.next = null;

        return head;
    }

    public int lengthOfLL(ListNode head) {
        int count = 0;

        ListNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}
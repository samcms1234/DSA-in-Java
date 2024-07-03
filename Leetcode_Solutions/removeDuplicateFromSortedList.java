package Leetcode_Solutions;

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
class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head.next;
        ListNode previous = head;

        while(current != null) {
            if(current.val == previous.val) {
                current = current.next;
            }
            else {
                previous = current;
                current = current.next;
            }

            ListNode temp = current;
            previous.next = temp;
            // System.out.println(previous.val);
            // System.out.println(current.val);
        }

        return head;
    }
}
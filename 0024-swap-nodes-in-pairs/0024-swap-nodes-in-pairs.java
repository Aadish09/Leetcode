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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        return swap(head);
    }
    
    public ListNode swap(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode p = head;
        ListNode q = p.next;
        ListNode r = q.next;
        q.next = p;
        p.next = swap(r);
        return q;
    }
}
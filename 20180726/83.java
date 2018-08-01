/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode slow = dummy;
        while (head != null) {
            if (head.val == slow.val) {
                head = head.next;
            } else {
                slow.next = head;
                slow = slow.next;
                head = head.next;
            }
        }
        slow.next = null;
        return dummy.next;
    }
}

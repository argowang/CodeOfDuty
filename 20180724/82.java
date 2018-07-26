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
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head.next;
        Boolean isDuplicate = false;
        while (fast != null) {
            if (fast.val == head.val) {
                isDuplicate = true;
                fast = fast.next;
            } else {
                if (isDuplicate) {
                    head = fast;
                    slow.next = head;
                } else {
                    slow = slow.next;
                    head = head.next;
                }
                isDuplicate = false;
                fast = fast.next;
            }
        }
        if (isDuplicate) {
            slow.next = fast;
        }
        return dummy.next;
    }
}

package July0716;

public class AddTwoNum {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);

        ListNode cur = new ListNode(0);
        root.next = cur;

        int carry =0;
        while(l1 !=null || l2 !=null) {
            int temp = 0;
            if(l1 == null ) {
                temp = l2.val + carry;
            } else if (l2 == null) {
                temp = l1.val + carry;
            } else {
                temp = l1.val + l2.val + carry;
            }

            int value = 0;
            if (temp > 10) {
                curry = 1;
                value = temp - 10;
            } else {
                value = temp;
                curry = 0;
            }
            ListNode next = new ListNode(value);
            cur.next = next;
            cur = cur.next;
            l1 = (l1!=null)? l1.next: null;
            l2 = (l2!=null)? l2.next: null;

        }
        if(carry>0) {
            cur.next = new ListNode(carry);
        }

        return root.next;
}


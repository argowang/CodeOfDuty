# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):     
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head == None or head.next == None:
            return True
        fast, pre, slow = head, None, head
        while fast and fast.next:
            fast = fast.next.next
            pre, slow.next, slow = slow, pre, slow.next
        if fast:
            slow = slow.next
        while pre and pre.val == slow.val:
            pre = pre.next
            slow = slow.next
        return not pre
  
        

        
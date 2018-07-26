# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        def fetchk(cur):
            q = []
            i = 0
            head = cur
            while cur.next and i < k - 1:
                q.append(cur)
                cur = cur.next
                i += 1
            if cur:
                q.append(cur)
            return (q, cur) if len(q) == k else (q, head)
        
        def reverse(queue):
            if not queue:
                return None
            head = queue.pop()
            cur = head
            while queue:
                next = queue.pop()
                cur.next = next
                cur = next
            return cur
        
        if not head:
            return None
        curgroup, cur = fetchk(head)
        head = cur
        while len(curgroup) == k:
            if cur.next:
                nextgroup, next = fetchk(cur.next)
                cur = reverse(curgroup)
                cur.next = next
                curgroup = copy.copy(nextgroup)
                cur = next
            else:
                print(cur.val)
                print([i.val if i else "None" for i in curgroup])
                cur = reverse(curgroup)
                print(cur.val)
                curgroup = []
                cur.next = None
        return head

        
            
        
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        cur = head
        count = 0
        while cur != None and count != k:
            cur = cur.next
            count += 1
        if count == k:
            cur = self.reverseKGroup(cur, k)
            while count != 0:
                tmp = head.next
                head.next = cur
                cur = head
                head = tmp
                count -= 1
            head = cur
        return head        

# Yes the 100% algorithm is append to a list and sort and create new linkedlist.....
# ...
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# My verbose solution..
# class Solution(object):        
#     def mergeKLists(self, lists):
#         """
#         :type lists: List[ListNode]
#         :rtype: ListNode
#         """
        
#         n = len(lists)
#         if n == 0:
#             return None
#         store = [ None for i in range(n)]
        
#         def findmin(store):
#             idx = -1
#             min_node = ListNode(float('inf'))
#             n = len(store)

#             for i in range(n):
#                 if store[i]:
#                     if store[i].val < min_node.val:
#                         min_node = store[i]
#                         idx = i
#             return min_node, idx
                   
#         def enrich(lists, idx, store):
#             if lists[idx]:
#                 store[idx] = lists[idx]
#                 lists[idx] = lists[idx].next
#             else:
#                 store[idx] = None
                
#         # Fulfill the store:
#         for i in range(n):
#             enrich(lists, i, store)

#         # Find the root
#         root, cur_idx = findmin(store)
#         if cur_idx == -1:
#             return []
        
#         enrich(lists, cur_idx, store)
#         cur = root
#         next, next_idx = findmin(store)
#         while next_idx != -1:
#             if cur.next != next:
#                 # Build Connection:
#                 cur.next = next
#                 cur = next
#                 cur_idx = next_idx
#             else:
#                 cur = cur.next
#             enrich(lists, cur_idx, store)
#             next, next_idx = findmin(store)
#         return root
                
# Use PriorityQueue:
class Solution(object): 
        
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        from Queue import PriorityQueue
        # Initilize a prev node for head
        rootprev = ListNode(0)
        cur = rootprev
        q = PriorityQueue()
        # Since each sublist is sorted, we only append the first node of each list to the priority queue
        for node in lists:
            if node: 
                q.put((node.val, node))
        # Merge list. everytime get a value out, remember to enrich the queue if there has next node for the current.
        while q.qsize() > 0:
            cur.next = q.get()[1]
            cur = cur.next
            # enrich the queue
            if cur.next:
                q.put((cur.next.val, cur.next))
        return rootprev.next
            
       
            
        
        
        
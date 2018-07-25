# Implement with double linkedlist
class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None
        
class LRUCache(object):
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.dic = {}
        # Initialize a head
        self.head = Node(0,0)
        self.tail = Node(0,0)
        self.head.next = self.tail
        self.tail.prev = self.head
      
    def add(self, node):
        p = self.tail.prev
        p.next = node
        self.tail.prev = node
        node.next = self.tail
        node.prev = p
        self.dic[node.key] = node
    
    def remove(self, node):
        prev = node.prev
        next = node.next
        prev.next = next
        next.prev = prev
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.dic:
            node = self.dic[key]
            self.remove(node)
            self.add(node)
            return node.value   
        return -1
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if key in self.dic:
            node = self.dic[key]
            self.remove(node)
        else:
            if len(self.dic) >= self.capacity:
                # Must has a head 
                oldnode = self.head.next
                self.remove(oldnode)
                self.dic.pop(oldnode.key, None)
        node = Node(key,value)
        self.add(node)

        
        


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
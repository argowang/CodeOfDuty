# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class NestedIterator(object):

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.queue = []
        self.rich_que(nestedList)
 
    def rich_que(self, nested):
        for nest in nested:
            if nest.isInteger():
                self.queue += [nest.getInteger()]
            else:
                self.rich_que(nest.getList())
    

    def next(self):
        """
        :rtype: int
        """
        cur = self.queue.pop(0)
        # if len(self.queue) == 0:
        #     self.rich_que()
        return cur
        
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.queue) > 0
        

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())
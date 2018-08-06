class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        if n == 0:
            return len(tasks)
        # Use number of idle to find the number of tasks:
        
        # dic = [0 for i in range(26)]
        # for i in tasks:
        #     dic[ord(i) - ord('A')] += 1
        # dic.sort()
        # max_length = dic[25] - 1
        # idle = max_length * n
        # for idx in range(24, -1, -1):
        #     idle -= min(max_length, dic[idx])
        # return idle + len(tasks) if idle > 0 else len(tasks)
    
        # Or just calculate the number of maxlength:
        
        dic = [0 for i in range(26)]
        for i in tasks:
            dic[ord(i) - ord('A')] += 1
        maxcount = 1
        maxlength =  0
        length = len(tasks)
        for size in dic:
            if maxlength < size:
                maxcount = 1
                maxlength = size
            elif size == maxlength:
                maxcount += 1
        posible_res = maxcount + (maxlength - 1) * (n + 1)
        return max(length,  posible_res)
        
                
                
        
        
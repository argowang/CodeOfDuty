class Solution(object):
    def add(self, a, b):
        m = len(a)
        n = len(b)
        res = [int(i) for i in a]
        i = m - n
        flag = False
        while i < m:
            res[i] += int(b[i - m + n])
            i += 1
        for i in range(m-1, -1, -1):
            if res[i] >= 2:
                if res[i] == 2:
                    res[i] = 0
                else:
                    res[i] = 1
                if i - 1 >= 0:
                    res[i - 1] += 1
                else:
                    flag = True
        if flag:
            re = ["1"] + [str(i) for i in res]
        else:
            re = [str(i) for i in res]
        return "".join(re)
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        m = len(a)
        n = len(b)
        if m >= n:
            return self.add(a,b)
        else:
            return self.add(b,a)
            
               
                
                
        
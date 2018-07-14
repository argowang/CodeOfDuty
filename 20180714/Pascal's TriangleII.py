class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        if rowIndex == 0:
            return [1]
        elif rowIndex == 1:
            return [1,1]
        else:
            res = [1,1]
            for i in range(2, rowIndex+1):
                new_result = [x for x in res]
                for j in range(1, i):
                    new_result[j] = res[j - 1] + res[j]
                new_result.append(1)
                res = [x for x in new_result]
            return res
            
            

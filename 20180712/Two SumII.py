class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        dic = {}
        for i in range(len(numbers)):
            if( target - numbers[i] in dic):
                return [dic[target - numbers[i]] + 1, i + 1]
            else:
                dic[numbers[i]] = i
        
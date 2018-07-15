class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        answer = 0
        zero_length = 1
        for i in flowerbed:
            if i == 0 :
                zero_length += 1
            else:
                if (zero_length >= 3):
                    answer += (zero_length - 1) // 2
                zero_length = 0
            if answer >= n:
                return True
        if zero_length >= 2:
            answer += (zero_length) // 2
        return answer >= n
    
            
            
        

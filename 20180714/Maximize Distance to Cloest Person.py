class Solution(object):
    def maxDistToClosest(self, seats):
        """
        :type seats: List[int]
        :rtype: int
        """
        dis = 0
        cur_dis = 0
        for i in range(len(seats)):
            if seats[i] == 0:
                cur_dis += 1
            else:
                if i - cur_dis - 1 < 0:
                    dis = max(dis, cur_dis)
                if cur_dis % 2 == 0:
                    dis = max(dis, cur_dis / 2)
                else:
                    dis = max(dis, cur_dis / 2 + 1)
                cur_dis = 0
        if cur_dis > dis:
            return cur_dis
        else:
            return dis
        

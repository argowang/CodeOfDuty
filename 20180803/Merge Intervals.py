# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        # Greedy Algo:
        intervals.sort(key=lambda x: x.start)
        idx = 0
        res = []
        while idx <= len(intervals) - 1:
            sta = intervals[idx].start
            end = intervals[idx].end
            if sta > end:
                idx += 1
            else:
                while idx <= len(intervals) - 1 and intervals[idx].start <= end:
                    # Becareful for the test case like: [1,4],[2,3] ... should return [1,4] ...
                    if intervals[idx].end > end:
                        end = intervals[idx].end
                    idx += 1
                res.append([sta, end])
        return res
        
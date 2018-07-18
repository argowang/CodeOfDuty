class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        res = "1"
        if n <= 1:
            return res
        for i in range(1, n):
            cur = 0
            new = []
            for i in range(len(res)):
                if res[i] != res[cur]:
                    new.append(str(i - cur))
                    new.append(res[cur])
                    cur = i
            new.append(str(len(res) - cur))
            new.append(res[cur])
            res = "".join(new)
        return res
        
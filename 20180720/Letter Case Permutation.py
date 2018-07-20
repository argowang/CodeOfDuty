class Solution(object):
    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        res = [""]
        for i in S:
            if i.isalpha():
                case = [i.upper(), i.lower()]
            else:
                case = [i]
            res = [re + c for re in res for c in case]
        return res
    
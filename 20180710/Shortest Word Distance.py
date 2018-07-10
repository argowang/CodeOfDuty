class Solution(object):
    def shortestDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        idx = -1
        res = len(words)
        for i, w in enumerate(words):
            if w == word1 or w == word2:
                if idx != -1 and words[idx] != w:
                    res = min(res, i - idx)
                idx = i
        return res
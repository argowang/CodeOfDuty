class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        # need, missing = collections.Counter(t), len(t)
        # i=I=J=0
        # for j, c in enumerate(s, 1):
        #     missing -= need[c] > 0
        #     need[c] -= 1
        #     if not missing:
        #         while i < j and need[s[i]] < 0:
        #             need[s[i]] += 1
        #             i += 1
        #         if not J or j - i < J - I:
        #             I = i
        #             J = j
        # return s[I:J]

        # Ordinary Method:
        if s == "" or t == "":
            return ""
        begin = end = mins = mine = 0
        need = {}
        window_size = len(s) + 1
        for c in t:
            need[c] = need.get(c,0) + 1
        missing = len(need)
        for end in range(len(s)):
            if s[end] in need:
                need[s[end]] -= 1
                if need[s[end]] == 0:
                    missing -= 1
            while not missing:
                if window_size > end - begin + 1:
                    window_size, mins, mine = end - begin + 1, begin, end
                if s[begin] in need:
                    need[s[begin]] += 1
                    if need[s[begin]] == 1:
                        missing += 1
                begin += 1
        return s[mins: mine + 1] if window_size != len(s) + 1 else ""
                
             
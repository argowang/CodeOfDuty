class Solution(object):
    def dfs(self, s, index, path, res):
        # Use index to mark the number of subsrting that splited by "."
        if index == 4:
            # Only if index == 4 we return and terminate calculation
            if not s:
                res.append(path[:-1])
            return
        for i in range(1, 4):
            # i must smaller then the length of the rest of s
            if i <= len(s):
                # choose 1 digit
                if i == 1:
                    self.dfs(s[i:], index + 1, path + s[:i] + ".", res)
                # choose 2 digit, should not start with 0
                elif i == 2 and s[0] != "0":
                    self.dfs(s[i:], index + 1, path + s[:i] + ".", res)
                # choose 1 digit, should not start with 0 and should smaller than 256
                elif i == 3 and s[0] != "0" and int(s[:3]) <= 255:
                    self.dfs(s[i:], index + 1, path + s[:i] + ".", res)
                    
                
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        res = []
        self.dfs(s, 0, "", res)
        return res
        
        
class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        # Backtracking method:
        def helper(idx, digits, path, res):
            if idx == len(digits):
                # Corner case: digits = ""
                if path != "":
                    res.append(path[:])
                return res
            else:
                i = digits[idx]
                if i == "2":
                    helper(idx + 1, digits, path+"a", res)
                    helper(idx + 1, digits, path+"b", res)
                    helper(idx + 1, digits, path+"c", res)
                elif i == "3":
                    helper(idx + 1, digits, path+"d", res)
                    helper(idx + 1, digits, path+"e", res)
                    helper(idx + 1, digits, path+"f", res)
                elif i == "4":
                    helper(idx + 1, digits, path+"g", res)
                    helper(idx + 1, digits, path+"h", res)
                    helper(idx + 1, digits, path+"i", res)
                elif i == "5":
                    helper(idx + 1, digits, path+"j", res)
                    helper(idx + 1, digits, path+"k", res)
                    helper(idx + 1, digits, path+"l", res)
                elif i == "6":
                    helper(idx + 1, digits, path+"m", res)
                    helper(idx + 1, digits, path+"n", res)
                    helper(idx + 1, digits, path+"o", res)
                elif i == "7":
                    helper(idx + 1, digits, path+"p", res)
                    helper(idx + 1, digits, path+"q", res)
                    helper(idx + 1, digits, path+"r", res)
                    helper(idx + 1, digits, path+"s", res)
                elif i == "8":
                    helper(idx + 1, digits, path+"t", res)
                    helper(idx + 1, digits, path+"u", res)
                    helper(idx + 1, digits, path+"v", res)
                elif i == "9":
                    helper(idx + 1, digits, path+"w", res)
                    helper(idx + 1, digits, path+"x", res)
                    helper(idx + 1, digits, path+"y", res)
                    helper(idx + 1, digits, path+"z", res)
                else:
                    helper(idx + 1, digits, path, res)
        res = []
        helper(0, digits, "", res)
        return res
                
                    
                    
                


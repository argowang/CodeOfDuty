class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        for i in s:
            if i == "(" or i == "[" or i == "{":
                stack.append(i)
            elif i == ")":
                if len(stack) == 0 or stack.pop() != "(":
                    return False
            elif i == "]":
                if len(stack) == 0 or stack.pop() != "[":
                    return False
            else:
                if len(stack) == 0 or stack.pop() != "{":
                    return False
        return True if len(stack) == 0 else False
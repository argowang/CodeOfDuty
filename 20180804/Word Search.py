class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        def helper(board, word, idx, idy):
            if len(word) == 0:
                return True
            if idx < 0 or idx >= len(board) or idy < 0 or idy >= len(board[0]) or board[idx][idy] != word[0]:
                return False
            else:
                cur = board[idx][idy]
                board[idx][idy] = "*"
                # My original method:
                    # down = helper(board, word[1:], idx + 1, idy)
                    # up = helper(board, word[1:], idx - 1, idy)
                    # right = helper(board, word[1:], idx, idy + 1)
                    # left = helper(board, word[1:], idx, idy - 1)
                    # return down or right or left or up
                # That causes TLE
                # But belows work !!!!!!
                # Cool... if you declare down, up, right, left and then return down or up or right or left, it will waste more time (actually 4 times in worse case). We just need to find the pattern exists in one direction; so the method above will cause TLE, but belows beat 70%..
                # Really impressive.
                # Remember, do not waste unnecessary time...
                res = helper(board, word[1:], idx + 1, idy) or helper(board, word[1:], idx - 1, idy) or helper(board, word[1:], idx, idy + 1) or helper(board, word[1:], idx, idy - 1)
                board[idx][idy] = cur
                return res
            
        if not board:
            return False
        for idx in range(len(board)):
            for idy in range(len(board[0])):
                if helper(board, word, idx, idy):
                    return True             
        return False

           
        

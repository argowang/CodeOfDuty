class Solution(object):
    def largeGroupPositions(self, S):
        """
        :type S: str
        :rtype: List[List[int]]
        """
        if (len(S) < 3):
            return []
        length_of_string = 1
        res = []
        current_symbol = ""
        for i in range(len(S)):
            if current_symbol == "":
                current_symbol = S[i]
            elif S[i] == current_symbol:
                length_of_string += 1
            elif length_of_string >= 3:
                match = [i - length_of_string, i-1]
                res.append(match)
                length_of_string = 1
                current_symbol = S[i]
            else:
                current_symbol = S[i]
                length_of_string = 1
        if length_of_string >= 3:
            res.append([len(S) - length_of_string, len(S)-1])
        return res
        

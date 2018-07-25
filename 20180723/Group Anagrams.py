class Solution(object):              
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        dic = {}
        for cur in strs:
            tmp = list(cur)
            tmp.sort()
            tmp = "".join(tmp)
            if tmp in dic:
                dic[tmp].append(cur)
            else:
                dic[tmp] = [cur]
        return [value for value in dic.values()]
                    
            
        
        
        
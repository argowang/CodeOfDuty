package July0721;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0, j =0; j<n;j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            maxLength = Math.max(maxLength, j-i+1);
            map.put(s.charAt(j),j+1);
        }

        return maxLength;
    }
}
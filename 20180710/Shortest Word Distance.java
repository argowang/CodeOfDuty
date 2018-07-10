class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int idx = -1;
        int res = words.length;
        for(int i = 0; i < words.length; i ++){
            if (words[i].equals(word1) || words[i].equals(word2)){
                if (idx != -1 && !words[idx].equals(words[i])){
                    res = Math.min(res, i - idx);
                }
                idx = i;
            }
        }
        return res;
    }
}


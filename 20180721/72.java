class Solution {
    public int minDistance(String word1, String word2) {
        int[][] minEdit = new int[word1.length()+1][word2.length()+1];

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0) {
                    minEdit[i][j] = j;
                } else if (j == 0) {
                    minEdit[i][j] = i;
                } else if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    minEdit[i][j] = minEdit[i-1][j-1];
                } else {
                    minEdit[i][j] = Math.min(Math.min(minEdit[i-1][j-1], minEdit[i][j-1]), minEdit[i-1][j]) + 1;
                }
            }
        }
        return minEdit[word1.length()][word2.length()];
    }
}

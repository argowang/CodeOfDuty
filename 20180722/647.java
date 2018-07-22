class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int counter = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = i ; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i < 3 || dp[i+1][j-1]);
                if (dp[i][j]) {
                    counter++;
                }
            }
        }
        return counter;
    }
}

class Solution2 {
    private int counter = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return counter;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            counter++;
            left--;
            right++;
        }
    }
}

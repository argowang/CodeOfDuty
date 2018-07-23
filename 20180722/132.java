class Solution {
  public int minCut(String s) {
    // Write your solution here
    int len = s.length();
    if (len == 0) {
      return 0;
    }
    boolean[][] isPalindrome = new boolean[len+1][len+1];
    int[] mincut = new int[len+1];
    mincut[0] = -1;

    for (int i = 1; i <= len; i++) {
      mincut[i] = mincut[i-1]+1;
      for (int j = i; j >= 1; j--) {
        if (i == j) {
          isPalindrome[j][i] = true;
          continue;
        }
        if (s.charAt(j-1) == s.charAt(i-1)){
          if (i - j == 1 || isPalindrome[j+1][i-1]) {
            isPalindrome[j][i] = true;
            mincut[i] = Math.min(mincut[i], mincut[j-1]+1);

          }
        }
      }
    }
    return mincut[len];
  }
}

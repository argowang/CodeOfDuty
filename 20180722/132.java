class Solution {
  public int minCut(String s) {
    // Write your solution here
    int len = s.length();
    if (len == 0) {
      return 0;
    }
    boolean[][] isPalindrome = new boolean[len][len];
    int[] mincut = new int[len];

    for (int i = 0; i < len; i++) {
      if (i == 0) {
        mincut[i] = 0;
      } else {
        mincut[i] = mincut[i-1]+1;
      }
      for (int j = i; j >= 0; j--) {
        if (i == j) {
          isPalindrome[j][i] = true;
          continue;
        }
        if (s.charAt(j) == s.charAt(i)){
          if (i - j == 1 || isPalindrome[j+1][i-1]) {
            isPalindrome[j][i] = true;
            if (j == 0) {
              mincut[i] = 0;
            } else {
              mincut[i] = Math.min(mincut[i], mincut[j-1]+1);
            }
          }
        }
      }
    }
    return mincut[len - 1];
  }
}

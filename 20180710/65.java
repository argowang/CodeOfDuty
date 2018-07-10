class Solution {
    public boolean isNumber(String s) {
      if (s == null) {
        return false;
      }
      s = s.trim();
      if (s.length() == 0) {
        return false;
      }
      int n = s.length();

      boolean seenNumberBeforeE = false;
      boolean seenSignBoforeE = false;
      boolean seenE = false;
      boolean seenSignAfterE = false;
      boolean seenDot = false;
      boolean seenNumberAfterE = false;

      for (int i = 0; i < n; i++) {
        char c = s.charAt(i);
        if (c == '+' || c == '-') {
          if (!seenE && (seenSignBoforeE || seenNumberBeforeE||seenDot)) {
            return false;
          }
          if (seenNumberAfterE||seenSignAfterE) {
            return false;
          }
          if (seenE) {
            seenSignAfterE = true;
          } else {
            seenSignBoforeE = true;
          }
        } else if (c <= '9' && c >= '0') {
          if (seenE) {
            seenNumberAfterE = true;
          } else {
            seenNumberBeforeE = true;
          }
        } else if (c == 'e' || c == 'E') {
          if (seenE) {
            return false;
          } else {
            seenE = true;
          }
        } else if (c == '.') {
          if (seenE || seenDot) {
            return false;
          } else {
            seenDot = true;
          }
        } else {
          return false;
        }
      }
      if (seenE && (!seenNumberAfterE || !seenNumberBeforeE)) {
        return false;
      }
      return seenNumberBeforeE;
    }
}

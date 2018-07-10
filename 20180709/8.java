class Solution {
    public int myAtoi(String str) {
      // Integer::=(SPC*) [+|-] (NUM+)(SPC*)
      // deal with null or empty string

      if(str == null) {
        return 0;
      }
      // no need to deal with spaces leading and trailing
      str = str.trim();
      if(str.length()==0) {
        return 0;
      }

      int n = str.length();
      int i = 0;

      boolean positive = true;
      // deal with sign
      if (str.charAt(i) == '+' || str.charAt(i) == '-') {
        positive = (str.charAt(i) == '+');
        i++;
      }

      long sum = 0;
      while (i < n) {
        if (str.charAt(i) > '9' || str.charAt(i) < '0'){
          return (int)(positive ? sum : sum * -1);
        }
        sum = sum * 10 + (str.charAt(i) - '0');
        if (positive && sum > Integer.MAX_VALUE) {
          return Integer.MAX_VALUE;
        }
        if (!positive && sum*-1 < Integer.MIN_VALUE) {
          return Integer.MIN_VALUE;
        }
        i++;
      }
      return (int)(positive ? sum : sum * -1);
    }
}

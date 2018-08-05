class Solution {
    public String longestPalindrome(String s) {
        // brute force
        String palidrome ="";
        if(s.length() <=1 || isPalindrome(s)) return s;
        for(int i = s.length(); i>0; i--) {
            for(int j = 0; j<=s.length()-i; j++) {
                String ss = s.substring(j,j+i);
                if(isPalindrome(ss)) {
                    return ss;
                }
            }
        }

        return palidrome;
    }

    public boolean isPalindrome(String s) {
        int head =0;
        int tail = s.length()-1;
        while(head < tail) {
           if(s.charAt(head) !=s.charAt(tail)) {
               return false;
           }
            head++;
            tail--;
        }
        return true;
    }

    // center index expand method
    public String longestPalindrome(String s) {
        // center index to find the palindrome
        int start = 0;
        int end = 0;
        for(int i = 0; i<s.length(); i++){
            int len1 = expandeFromCenter(s, i, i);  // odd
            int len2 = expandeFromCenter(s,i,i+1);  // even
            int len = Math.max(len1,len2);

            // max length is len, center is i, we can get the start and end index in string s
            if(len > end-start) {
                start = i - (len-1)/2;
                end = i+ len/2;

            }
        }
        return s.substring(start,end+1);
    }
        // max length of palidrome string s start from left
    public int expandeFromCenter(String s, int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
            return right-left-1;
    }
}

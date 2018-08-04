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
}

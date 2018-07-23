class Solution {
  /*
  * 7. reverse a number
  */
    public int reverse(int x) {
        if (x>Integer.MAX_VALUE || x<Integer.MIN_VALUE) {
            return 0;
        }
        int cur = x;
        int rev = 0;
        while(cur!= 0) {
            int tail = cur%10;
            int temp = rev;

            rev = rev*10 +tail;
            if((rev-tail)/10 != temp) {
                return 0;
            }
            cur = cur/10;
        }
        return rev;
    }


    /*
    * 9. palidrome Numbers
    */

    public boolean isPalindrome(int x) {
        int original = x;
        int rev = 0;
        if (x < 0) {
            return false;
        } else if (x ==0 ) {
            return true;
        }
        while( x!= 0 ) {

            rev = rev * 10 + x%10;
            x = x /10;
        }
        if (rev == original) {
            return true;
        }
        return false;
    }

}

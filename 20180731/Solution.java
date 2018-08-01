class Solution {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        if (x == 0) return true;

        int reverse = 0;
        int cur = x;
        while (cur != 0) {
            int temp = cur%10;
            reverse= reverse*10 + temp;
            cur = cur/10;
        }
        if(reverse == x) {
            return true;
        }
        return false;
    }
}

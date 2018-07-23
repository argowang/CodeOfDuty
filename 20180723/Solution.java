class Solution {
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
}

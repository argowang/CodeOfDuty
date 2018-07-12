class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        int res = 0;
        int i = 32;
        while (i > 0) {
            res += n & 1;
            n >>>= 1;
            i--;
        }
        return res == 1;
    }
}

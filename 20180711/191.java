public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        int i = 32;
        while (i > 0) {
            res += n & 1;
            n >>>= 1; // use >>> for unsigned shift
            i--;
        }
        return res;
    }
}

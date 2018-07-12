public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int mask = 1<<31;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                result |= mask;
            }
            mask >>>= 1;
            n >>>= 1;
        }
        return result;
    }
}

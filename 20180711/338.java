class Solution {
    public int[] countBits(int num) {
        int size = 1;
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i == 2*size) {
                size = i;
            }
            result[i] = 1 + result[i-size];
        }
        return result;
    }
}

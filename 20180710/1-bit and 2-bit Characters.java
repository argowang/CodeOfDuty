class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int idx = 0;
        int size = bits.length;
        while(idx < size - 1){
            idx += bits[idx] + 1;
        }
        return idx == size - 1;
    }
}

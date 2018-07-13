class Solution {
    public int dominantIndex(int[] nums) {
        int idx = 0;
        while(idx < nums.length){
            int i = 0;
            while(i < nums.length && ( i == idx || nums[idx] >= 2 * nums[i])){
                i += 1;
            }
            if (i == nums.length){
                return idx;
            }
            idx += 1;
        }
        return -1;
    }
}

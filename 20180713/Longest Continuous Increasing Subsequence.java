class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int idx = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i-1]){
                res = Math.max(res, i - idx);
                idx = i;
            }
        }
        return Math.max(res, nums.length - idx);
    }
}

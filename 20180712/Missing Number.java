class Solution {
    public int missingNumber(int[] nums) {
        int whole_n = nums.length;
        int add_whole = (0 + whole_n) * (whole_n + 1) / 2;
        for(int i = 0; i < nums.length; i ++){
            add_whole -= nums[i];
        }
        return add_whole;
    }
}

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0, j = -1;
        int r = nums.length - 1, i = 0;
        int min_nums = Integer.MAX_VALUE, max_nums = Integer.MIN_VALUE;
        while( r >= 0){
            max_nums = Math.max(max_nums, nums[l]);
            if (nums[l] != max_nums){
                j = l;
            }
            min_nums = Math.min(min_nums, nums[r]);
            if(nums[r] != min_nums){
                i = r;
            }
            r -= 1;
            l += 1;
        }
        return j - i + 1;

    }
    
}

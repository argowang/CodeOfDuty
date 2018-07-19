class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentMax > 0) {
                currentMax += nums[i];
            } else {
                currentMax = nums[i];
            }
            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }
        return globalMax;
    }
}

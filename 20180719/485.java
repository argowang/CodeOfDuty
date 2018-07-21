class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int globalMax = 0;
        int currentMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentMax++;
                globalMax = Math.max(currentMax, globalMax);
            } else {
                currentMax = 0;
            }
        }
        return globalMax;
    }
}

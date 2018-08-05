class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
          // do two sum
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[left] + nums[right] + nums[i] - target;
                if (Math.abs(tmp) < Math.abs(result-target)) {
                    result = nums[left] + nums[right] + nums[i];
                }
                if (tmp == 0) {
                    return result;
                } else if (tmp > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
            // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
          // do two sum
            int newTarget = -nums[i];
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == newTarget) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                } else if (nums[left] + nums[right] < newTarget) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}

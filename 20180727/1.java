class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> expected = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (expected.containsKey(nums[i])) {
                result[0] = expected.get(nums[i]);
                result[1] = i;
                break;
            } else {
                expected.put(target-nums[i], i);
            }
        }
        return result;
    }
}

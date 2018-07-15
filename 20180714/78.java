class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        List<Integer> current = new ArrayList<Integer>();
        helper(nums, current, result, 0);
        return result;
    }

    private void helper(int[] nums, List<Integer> current, List<List<Integer>> result, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        helper(nums, current, result, index + 1);
        current.add(nums[index]);
        helper(nums, current, result, index + 1);
        current.remove(current.size() - 1);
    }
}

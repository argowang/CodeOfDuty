class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        List<Integer> curResult = new ArrayList<>();
        helper(nums, result, curResult, 0);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> curResult, int level) {
        if (level == nums.length) {
            result.add(new ArrayList<Integer>(curResult));
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = level; i < nums.length; i++) {
            if (used.add(nums[i])) {
                curResult.add(nums[i]);
                swap(nums, level, i);
                helper(nums, result, curResult, level + 1);
                curResult.remove(curResult.size()-1);
                swap(nums, level, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

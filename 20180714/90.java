import java.util.Arrays;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<Integer>();
        helper(nums, current, result, 0);
        return result;
    }

    private void helper(int[] nums, List<Integer> current, List<List<Integer>> result, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        current.add(nums[index]);
        helper(nums, current, result, index + 1);
        int curNum = current.remove(current.size() - 1);
        while (index < nums.length - 1 && nums[index+1] == curNum) {
            index++;
        }
        helper(nums, current, result, index + 1);
    }
}

import java.util.stream.Collectors;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, result, 0);
        return result;
    }
    private void helper(int[] nums, List<List<Integer>> result, int index) {
        if (index == nums.length-1) {
            result.add(new ArrayList<Integer>(Arrays.stream(nums).boxed().collect(Collectors.toList())));
            return;
        }
        for (int i = index ; i < nums.length; i++) {
            swap(nums, index, i);
            helper(nums, result, index + 1);
            swap(nums, index, i);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

import java.util.Arrays;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> current = new ArrayList<Integer>();
        helper(nums, result, current);
        return result;
    }
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(current.contains(nums[i])) {
                continue;
            }
            current.add(nums[i]);
            helper(nums, result, current);
            current.remove(current.size() - 1);
        }
    }
}

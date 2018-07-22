class Solution {
    private int len = 0;
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        len = nums.length;
        if (len == 0) {
            return result;
        }
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void dfs(int[] nums, int currIndex, List<Integer> currSet, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(currSet));
        
        for (int i = currIndex; i < len; i++) {
            currSet.add(nums[i]);
            dfs(nums, i+1, currSet, result);
            currSet.remove(currSet.size()-1);
        }
    }
}

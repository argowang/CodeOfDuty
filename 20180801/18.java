class Solution {
    int len = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }
    
    public List<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (index >= len) {
            return result;
        }
        if (k == 2) {
            int lo = index, hi = len - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[lo], nums[hi]));
                    result.add(temp);
                    // remove duplicate
                    while (lo < hi && nums[lo+1] == nums[lo]) lo++;
                    while (lo < hi && nums[hi-1] == nums[hi]) hi--;
                    lo++; hi--;
                } else if (nums[lo] + nums[hi] < target){
                    lo++;
                } else {
                    hi--;
                }
            }
        } else {
            for (int i = index; i < len - k + 1; i++) {
                List<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                if (temp != null) {
                    for (List<Integer> each: temp) {
                        each.add(0, nums[i]);
                    }
                    result.addAll(temp);
                }
                while ( i < len -1 && nums[i+1] == nums[i]) i++;
            }
        }
        return result;
    }
}

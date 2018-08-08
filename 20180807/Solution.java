class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    if(nums == null || nums.length < 3) return res;
    for(int i = 0; i < nums.length -2; i++) {
      if (i==0 || nums[i] != nums[i-1]) {
        int low = i+1;
        int hi = nums.length -1;
        int sum = 0-nums[i];
        while(low<hi) {
          if(nums[low] + nums[hi] == sum ){
            while(low<hi && nums[low] == nums[low+1]) low++;
            while(low<hi && nums[hi] == nums[hi-1]) hi--;
            low++;
            hi--;
          } else if(nums[low] + nums[hi]>sum) {
            hi--;
          } else {
            low++;
          }
        }
      }
    }
    return res;
  }
}

class Solution {
    public boolean checkPossibility(int[] nums) {
        int ans = -1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                if( ans != -1){
                    return false;
                }
                else{
                    ans = i - 1;
                }
            }
        }
        return ans == 0 || ans == nums.length - 2 || ans == -1 || nums[ans - 1] <= nums[ans + 1] || nums[ans] <= nums[ans + 2];
    }
}

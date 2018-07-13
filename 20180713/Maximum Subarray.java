class Solution {
    public int maxSubArray(int[] nums) {
        // DP method:
        // int[] dp = new int[nums.length];
        // dp[0] = nums[0];
        // int res = dp[0];
        // for(int i = 1; i < nums.length; i++){
        //     dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        //     res = Math.max(res, dp[i]);
        // }
        // return res;
        
        // Use constant extra space method:
        int res = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(sum < 0){
                sum = nums[i];
            }
            else{
                sum += nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}

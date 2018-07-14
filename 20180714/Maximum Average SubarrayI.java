class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(k > nums.length){
            int sum = 0;
            for(int i :nums){
                sum += i;
            }
            return sum / nums.length;
        }
        else {
            double cur_sum = 0;
            for(int i = 0; i < k; i ++){
                cur_sum += nums[i];
            }
            double res = cur_sum;
            for(int j = 1; j < nums.length - k + 1; j ++){
                cur_sum = cur_sum  - nums[j-1] + nums[j + k - 1];
                res = Math.max(res, cur_sum);
            }
            return res / k;
        }
    }
}

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length; 
        int maxSum = 0;
        int[] sum = new int[len+1];
        int[] posLeft = new int[len];
        int[] posRight = new int[len];
        int[] ans = new int[3];
        for (int i = 0; i < len; i++) {
            sum[i+1] = sum[i] + nums[i]; 
        }
        
        // starting index of left max sum interval
        for (int i = k, tot = sum[k]-sum[0]; i < len; i++) {
            if (sum[i+1] - sum[i+1-k] > tot) {
                posLeft[i] = i+1-k;
                tot = sum[i+1] - sum[i+1-k];
            } else {
                posLeft[i] = posLeft[i-1];
            }
        }
        // starting index of right max sum interval
        posRight[len-k] = len-k;
        for (int i = len-k-1, tot = sum[len] - sum[len-k]; i >=0; i--) {
            if (sum[i+k] - sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i+k] - sum[i];
            } else {
                posRight[i] = posRight[i+1];
            }
        }
        // iterate through all possible index i
        for (int i = k; i <= len-2*k; i++) {
            int left = posLeft[i-1];
            int right = posRight[i+k];
            int tot = (sum[i+k] - sum[i]) + (sum[left+k] - sum[left]) + (sum[right+k] - sum[right]);
            if (tot > maxSum) {
                maxSum = tot;
                ans[0] = left;
                ans[1] = i;
                ans[2] = right;
            }
        }
        return ans;
    }
}

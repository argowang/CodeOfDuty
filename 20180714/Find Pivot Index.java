class Solution {
    public int pivotIndex(int[] nums) {
        int sum_nums = 0;
        for( int i: nums){
            sum_nums += i;
        }
        int left_sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(left_sum == sum_nums - left_sum - nums[i]){
                return i;
            }
            else{
                left_sum += nums[i];
            }
        }
        return -1; 
    }
}

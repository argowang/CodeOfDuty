class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == 1){
                count += 1;
            }
            else{
                result = Math.max(result, count);
                count = 0;
            }
        }
        result = Math.max(result, count);
        return result;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for(int i = 0; i < nums.length; i ++){
            if(count == 0){
                candidate = nums[i];
            }
            if (candidate == nums[i]){
                count += 1;
            }
            else{
                count -= 1;
            }
        }
        return candidate;
    }
}

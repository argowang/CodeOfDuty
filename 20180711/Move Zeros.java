class Solution {
    public void moveZeroes(int[] nums) {
        int i = -1;
        int j = i + 1;
        int p = nums.length - 1;
        while (j <= p){
            if(nums[j] != 0){
                i += 1;
                int tmp = nums[i];
                nums[i]  = nums[j];
                nums[j] = tmp;
            }
            j += 1;
        }
    }
}

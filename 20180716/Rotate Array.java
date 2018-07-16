class Solution {
    public void reverse(int[] nums, int sta, int end){
        if(end >= sta){
            for(int i = 0; i < (end - sta)/2 + 1; i++){
                int tmp = nums[i + sta];
                nums[i + sta] = nums[end - i];
                nums[end - i] = tmp;
            }
        }
    }
    public void rotate(int[] nums, int k) {
        if(k > nums.length){
            k = (k - nums.length) % nums.length;
        }
        if(k > 0){
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
        }
    }
}

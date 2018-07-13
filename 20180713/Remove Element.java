class Solution {
    public int removeElement(int[] nums, int val) {
        int i = -1;
        int j = 0;
        int p = nums.length - 1;
        while(j <= p){
            if (nums[j] != val){
                i += 1;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            j += 1;
        }
        return i + 1;
    }
}

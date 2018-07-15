class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        } 
        // int i = 0;
        // int j = 1;
        // int p = nums.length - 1;
        // while( j<= p){
        //     if(nums[j] != nums[i]){
        //         i += 1;
        //         int tmp = nums[j];
        //         nums[j] = nums[i];
        //         nums[i] = tmp;
        //     }
        //     j += 1;
        // }
        // return i + 1;
        int i = 1;
        int j = 1;
        while (j < nums.length){
            if(nums[j] != nums[j-1]){
                nums[i] = nums[j];
                i += 1;
            }
            j += 1;
        }
        return i;
    }
}

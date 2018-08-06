class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums ==null || nums.length==0) return 0;
        int former = nums[0];
        int counter = 0; // delete numbers
        for(int i =1; i< nums.length-counter; i++){
            if(former != nums[i]) {
                former = nums[i];
            } else {
                // delete the duplicated element
                counter++;
                for(int j = i; j<nums.length-counter; j++) {
                    nums[j]=nums[j+1];
                }
                i--;
            }
        }
        return nums.length-counter;
    }
}

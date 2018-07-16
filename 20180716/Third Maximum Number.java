class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length < 3){
            if(nums.length == 1){
                return nums[0];
            } else if(nums.length == 2){
                return Math.max(nums[0], nums[1]);
            }
        }
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int count = 0;
        for(int i: nums){
            if((count == 0 && i == max1) || (count == 1 && i == max2 && i != max1)){
                count += 1;
            }
            if(i > max1){
                max3 = max2;
                max2 = max1;
                max1 = i;
                count += 1;
            }
            else if(i > max2 && i != max1){
                max3 = max2;
                max2 = i;
                count += 1;
            }
            else if(i >= max3 && i != max2 && i != max1){
                max3 = i;
                count += 1;
            }
        }
        return count >= 3 ? max3 : max1;
    }
}


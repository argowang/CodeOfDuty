class Solution {
    public int binarySearch(int[] nums, int i, int j, int target){
        if (i >= j){
            if(nums[i] < target){
                return i + 1;
            }
            else{
                return i;
            }
        }
        else{
            int mid = (i + j) / 2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] > target){
                return binarySearch(nums, i, mid - 1, target);
            }
            else {
                return binarySearch(nums, mid + 1, j, target);
            }
        }
    }
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
}

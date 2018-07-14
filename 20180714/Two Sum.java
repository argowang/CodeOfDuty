class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> dic = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(dic.containsKey(target - nums[i])){
                return new int[] {dic.get(target - nums[i]), i};
            }
            else{
                dic.put(nums[i], i);
            }
        }
        return new int[] {-1,-1};
    }
}

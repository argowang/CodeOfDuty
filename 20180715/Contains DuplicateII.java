ss Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> dic = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            // Update map with new value, return old value
            Integer ord = dic.put(nums[i], i);
            if(ord != null && i - ord <= k){
                return true;
            }
        }
        return false;
    }
}

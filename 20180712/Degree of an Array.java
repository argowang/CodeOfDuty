class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> dic = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < nums.length; i++){
            if (dic.containsKey(nums[i])){
                dic.get(nums[i]).add(i);
            } else {
                dic.put(nums[i], new ArrayList<Integer>());
                dic.get(nums[i]).add(i);
            }
        }
        int frequency = 0;
        int res = nums.length;
        for(Map.Entry<Integer, ArrayList<Integer>> entry: dic.entrySet()) {
            ArrayList<Integer> value = entry.getValue();
            if (value.size() > frequency){
                frequency = value.size();
                res = value.get(value.size() -1 ) - value.get(0) + 1;
            }
            else if (value.size() == frequency){
                res = Math.min(res, value.get(value.size() -1 ) - value.get(0) + 1);
            }
        }
        return res;   
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for (int num: nums) {
            if (!map.containsKey(num)) {
                int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
                int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;    
                int sum = left + right + 1;
                map.put(num, sum);
                
                res = Math.max(res, sum);
                
                // update boundary
                map.put(num-left, sum);
                map.put(num+right, sum);
            } else {
                continue;
            }
        }
        return res;
    }
}

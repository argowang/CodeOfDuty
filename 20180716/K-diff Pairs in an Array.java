class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> myset = new HashSet<Integer>();
        for(int p: nums){
            myset.add(p);
        }
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0;
        if(k == 0){
            for(int i:nums){
                if (count.containsKey(i))
                    count.put(i, count.get(i) + 1);
                else
                    count.put(i, 1);   
            }
            for(int j:myset){
                if (count.get(j) > 1){
                    res += 1;
                }
            }
        }
        else if(k > 0){
            for(int i :myset){
                if(myset.contains(i+k)){
                    res += 1;
                }
            }    
        }
        return res;
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int x: nums){
            if(x < min){
                min = x;
            }
            if(x > max){
                max = x;
            }
        }
        boolean[] bs = new boolean[max - min + 1];
        for (int x:nums){
            if(bs[x-min]){
                return true;
            }
            bs[x-min] = true;
        }
        return false;
    }
}

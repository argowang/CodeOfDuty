class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList();
        int length = nums.length;
        if (length <= 1){
            return res;
        }
        boolean[] check = new boolean[length];
        for(int i = 0; i < length; i++){
           check[nums[i] - 1] = true;
        }
        for(int i = 0; i < length; i++){
           if(!check[i]){
               res.add(i+1);
           }
        }
        return res;
    }
}

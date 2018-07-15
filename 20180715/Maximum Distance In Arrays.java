class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min1 = Integer.MAX_VALUE; 
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE; 
        int max2 = Integer.MIN_VALUE;
        int min_idx = -1;
        int max_idx = -1;
        for(int i = 0; i < arrays.size(); i++){
            if(arrays.get(i).get(arrays.get(i).size() - 1) > max1){
                max2 = max1;
                max1 = arrays.get(i).get(arrays.get(i).size() - 1);
                max_idx = i;
            }
            else if(arrays.get(i).get(arrays.get(i).size() - 1) > max2){
                 max2 = arrays.get(i).get(arrays.get(i).size() - 1);
            }
            if (arrays.get(i).get(0) < min1){
                min2 = min1;
                min1 = arrays.get(i).get(0);
                min_idx = i;
            } else if(arrays.get(i).get(0) < min2){
                min2 = arrays.get(i).get(0);
            }
        }
        if(min_idx != max_idx){
            return Math.abs(max1 - min1);
        }
        else{
            return Math.max(Math.abs(max1 - min2), Math.abs(max2 - min1));
        }
    }
}

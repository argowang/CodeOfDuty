class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int origin_r = nums.length;
        if (origin_r < 1){
            return nums;
        }
        int origin_c = nums[0].length;
        if (origin_c * origin_r != r * c){
            return nums;
        }
        List<Integer> expand = new ArrayList();
        for(int i = 0; i < origin_r; i++){
            for (int j = 0; j < origin_c; j ++){
                expand.add(nums[i][j]);
            }
        }
        int[][] res = new int[r][c];
        
        for(int i = 0; i < r; i++){
            for (int j = 0; j < c; j ++){
                res[i][j] = expand.get(j + c * i);
            }
        }
        return res;
    }
}

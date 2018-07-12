class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] res = new int[m][];
        for(int i = 0; i < m; i++){
            res[i] = M[i].clone();
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int total = M[i][j];
                int count = 1;
                if(i > 0){
                    total += M[i-1][j];
                    count += 1;
                }
                if(j > 0){
                    total += M[i][j-1];
                    count += 1;
                }
                if(i < m - 1){
                    total += M[i+1][j];
                    count += 1;
                }
                if( j < n - 1){
                    total += M[i][j+1];
                    count += 1;
                }
                if(i > 0 && j > 0){
                    total += M[i-1][j-1];
                    count += 1;
                }
                if(i > 0 && j < n - 1){
                    total += M[i-1][j+1];
                    count += 1;
                }
                if(i < m - 1 && j > 0){
                    total += M[i+1][j-1];
                    count += 1;
                }
                if(i < m - 1 && j < n - 1){
                    total += M[i+1][j+1];
                    count += 1;
                }
                res[i][j] = total / count;
            }
        }
        return res;
    }
}

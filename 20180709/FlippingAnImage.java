class Solution {
    public int invert(int x){
        if(x == 0){
            return 1;
        }
        else{
            return 0;
        }
    }
    public int[] exchange(int x, int y){
        int[] res = {y, x};
        return res;
    }
    public int[][] flipAndInvertImage(int[][] A) {
        int M = A.length;
        if(M < 1){
            int[][] no_item = {{}};
            return no_item;
        }
        for(int i = 0; i < M; i++){
            for(int j = 0; j < A[0].length / 2; j++){
                A[i][j] = invert(A[i][j]);
                A[i][A[0].length - 1 - j] = invert(A[i][A[0].length - 1 - j]);
                int[] exc = exchange(A[i][j], A[i][A[0].length - 1 - j]);
                A[i][j] = exc[0];
                A[i][A[0].length - 1 - j] = exc[1];
            }
            if(A[0].length % 2 != 0){
                    A[i][A[0].length / 2] = invert(A[i][A[0].length / 2]);
            }
        }
        return A;
    }
}

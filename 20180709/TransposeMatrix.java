class Solution {
    public int[][] transpose(int[][] A) {
        int M = A.length;
        if (M < 1){
            int[][] res = {{}};
            return res;
        }
        int[][] result = new int[A[0].length][];
        int N = A[0].length;
        List<Integer> expand = new ArrayList<>();
        for(int row = 0; row < M; row ++){
            for(int col=0; col < N; col++){
                expand.add(A[row][col]);
            }
        }
        for(int i = 0; i < N; i ++){
            int[] match = new int[A.length];
            for (int j = 0; j < M; j++){
                match[j] = expand.get(i +(j * N));
            }
            result[i] = match;
        }
        return result;
    }
}

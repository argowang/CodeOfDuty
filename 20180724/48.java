class Solution {
    public void rotate(int[][] matrix) {
        int offset = 0;
        int size = matrix.length;
        while(size > 1) {
            for (int i = 0; i < size - 1; i++) {
                int tmp = matrix[offset][offset+i];
                matrix[offset][offset+i] = matrix[offset+size-1-i][offset];
                matrix[offset+size-1-i][offset] = matrix[offset+size-1][offset+size-1-i];
                matrix[offset+size-1][offset+size-1-i] = matrix[offset+i][offset+size-1];
                matrix[offset+i][offset+size-1] = tmp;
            }
            size -=2;
            offset += 1;
        }
    }
}

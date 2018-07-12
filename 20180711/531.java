class Solution {
    public int findLonelyPixel(char[][] picture) {
        if (picture == null) {
            return 0;
        }
        int n = picture.length;
        int m = picture[0].length;
        
        int[] row = new int[n];
        int[] col = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int counter = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 'B' && row[i] == 1 && col[j] == 1) {
                    counter++;
                }
            }
        }
        return counter;
        
    }
}

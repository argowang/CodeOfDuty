class Solution {
    private int startPixelColor;
    private int newColor;
    private int[][] image;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        startPixelColor = image[sr][sc];
        // special case where originalColor is the same to the newColor. If not handled, we will enter an infinite loop
        if (startPixelColor == newColor) {
            return image;
        }
        this.newColor = newColor;
        this.image = image;
        dfs(sr, sc);
        return image;
    }
    
    public void dfs(int r, int c) {
        if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == startPixelColor) {
            image[r][c] = newColor;
            dfs(r-1, c);
            dfs(r+1, c);
            dfs(r, c-1);
            dfs(r, c+1);
        }
    }
}

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
          return 0;
        }
        int[] leftmax = new int[height.length];
        int[] rightmax = new int[height.length];
        leftmax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
          leftmax[i] = Math.max(height[i], leftmax[i-1]);
        }
        rightmax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
          rightmax[i] = Math.max(height[i], rightmax[i+1]);
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
          sum += Math.min(leftmax[i], rightmax[i]) - height[i];
        }

        return sum;
    }
}

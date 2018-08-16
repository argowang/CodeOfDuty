// M[i] represents the length of longest ascending subsequence ends with a[i]
// base case M[0] = 0
// induction rule: M[i] = Math.max(M[j]) + 1, j < i, a[j] > a[i]
// time complexity: O(n^2)
// space complexity: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] mark = new int[nums.length];
        if (nums == null || nums.length == 0) {
          return 0;
        }
        mark[0] = 1;
        int globalmax = 1;
        for (int i = 1; i < nums.length; ++i) {
          int currentmax = 1;
          for (int j = i - 1; j >= 0; --j) {
             if (nums[j] < nums[i]) {
               currentmax = Math.max(currentmax, mark[j] + 1);
             }
          }
          mark[i] = currentmax;
          globalmax = Math.max(globalmax, currentmax);
        }
        return globalmax;
    }
}
// M[i] represents the smallest value having the ascending subsequence of length i
// time complexity: O(nlogn)
// space complexity: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
          return 0;
        }
        int[] mark = new int[nums.length + 1];
        mark[1] = nums[0];
        int globalmax = 1;
        for (int i = 1; i < nums.length; i++) {
          int index = find(mark, 1, globalmax, nums[i]);
          if (index == globalmax) {
            mark[++globalmax] = nums[i];
          } else {
            mark[index+1] = nums[i];
          }
        }
        return globalmax;
    }
     private int find(int[] mark, int left, int right, int target) {
        while (left <= right) {
          int mid = left + (right - left)/2;
          if (mark[mid] >= target) {
            right = mid - 1;
          } else {
            left = mid + 1;
          }
        }
    return right;
  }
}

class Solution {
    public int jump(int[] nums) {
        int cur = 0;
        int next = 0;
        int jump = 0;
        for (int i = 0; i < nums.length; i++) {
          if (i > cur) {
            jump++;
            if (cur == next) {
              return -1;
            }
            cur = next;
          }
          next = Math.max(next, i+nums[i]);
        }
        return jump;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cur = 0;
        int next = 0; // max index next step can get

        for (int i = 0; i < nums.length; i++) {
            if (i > cur) {
                if (cur == next) {
                    return false;
                }
                cur = next;
            }
            next = Math.max(next, i+nums[i]);
        }
        return true;
    }
}

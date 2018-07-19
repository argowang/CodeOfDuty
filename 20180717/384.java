import java.util.Arrays;
class Solution {
    private int[] origin;

    public Solution(int[] nums) {
        origin = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        int n = origin.length;
        int[] result = Arrays.copyOf(origin, n);

        for(int i = 0; i < n; i++){
            int j = random.nextInt(n-i)+i;
            swap(result, i, j);
        }
        return result;
    }
    private void swap(int[] result, int i, int j){
        int tmp = result[i];
        result[i] = result[j];
        result[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

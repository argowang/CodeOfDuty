class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int lo = 0, hi = numbers.length-1;
        while (lo < hi) {
            int currSum = numbers[lo] + numbers[hi];
            if (currSum == target) {
                result[0] = lo+1;
                result[1] = hi+1;
                return result;
            } else if (currSum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return result;
    }
}

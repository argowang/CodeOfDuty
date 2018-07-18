class Solution {
    public int nextGreaterElement(int n) {
        char[] number = (n + "").toCharArray();
        int i = number.length - 2;
        for (; i >= 0 ; i--) {
            if (number[i] < number[i+1]) {
                break;
            }
        }
        // case where the number is descending, meaning no number could be larger.
        if (i == -1) {
            return -1;
        }
        
        char minNum = '9';
        int minNumIndex = number.length-1;
        for (int j = i+1; j < number.length; j++) {
            // find the smallest digit that is larger than previous digit.
            if (number[j] < minNum && number[j] > number[i]) {
                minNum = number[j];
                minNumIndex = j;
            }
        }
        
        // swap the two digits
        char temp = number[i];
        number[i] = number[minNumIndex];
        number[minNumIndex] = temp;
        
        Arrays.sort(number, i+1, number.length);
        long val = Long.parseLong(new String(number));
        
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
        
    }
}

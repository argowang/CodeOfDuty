class Solution {
    public int[] plusOne(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i ++){
            sum += digits[i];   
        }
        if (sum == digits.length * 9){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for(int i = 0; i < digits.length; i++){
                res[i+1] = 0;
            }
            return res;
        }
        else{
            int i = digits.length - 1;
            if (digits[i] == 9){
                while(i > -1 && digits[i] == 9){
                    digits[i] = 0;
                    i -= 1;
                }
                digits[i] += 1;
            } else{
                digits[i] += 1;
            }
            return digits;
        }
    
        
    }
}

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int answer = 0;
        int zero_length = 1;
        for(int i: flowerbed){
            if(i == 0){
                zero_length += 1;
            }
            else{
                if (zero_length >= 3){
                    answer += (zero_length - 1) / 2;
                }
                zero_length = 0;
            }
            if (answer >= n){
                return true;
            }
        }
        if (zero_length >= 2){
            answer += (zero_length / 2);
        }    
        return answer >= n;
    }
}

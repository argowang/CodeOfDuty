class Solution {
    public int maxProfit(int[] prices) {
        int pro = 0;
        if (prices.length <= 1){
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        for(int i = 1; i < prices.length; i ++){
            if(prices[i] > prices[i-1]){
                max = prices[i];
                pro = Math.max(pro, prices[i] - min);
            }
            if (prices[i] < min){
                min = prices[i];
                max = min;
            }
        }
        return pro;
    }
}

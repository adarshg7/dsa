class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int min = prices[0];
        int maxP = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else{
                maxP = Math.max(maxP, prices[i] - min);
            }
        }
        return maxP;
    }
}

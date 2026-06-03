class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int profit = 0;
        int min = prices[0];

        for(int i = 1; i < n; i++){
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return profit;

        // for(int i = 0; i < n - 1; i++){
        //     for(int j = i+1; j < n; j++){
        //         profit = Math.max(profit, prices[j] - prices[i]);
        //     }
        // }
        // return profit;
    }
}

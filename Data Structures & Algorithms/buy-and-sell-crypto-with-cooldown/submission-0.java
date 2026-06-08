class Solution {
    public int solve(int ind, int canBuy, int[] prices, int[][] dp){

        if(ind >= prices.length) return 0;

        if(dp[ind][canBuy] != -1) return dp[ind][canBuy];
 
        if(canBuy == 1){
            int buy = -prices[ind] + solve(ind + 1, 0, prices, dp);
            int skip = solve(ind + 1, 1, prices, dp);

            return dp[ind][canBuy] = Math.max(buy, skip);
        }else{
            int sell = prices[ind] + solve(ind + 2, 1, prices, dp);
            int skip = solve(ind + 1, 0, prices, dp);

            return dp[ind][canBuy] = Math.max(sell, skip);
        }
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][] dp = new int[n][2];
        // for(int[] row: dp){
        //     Arrays.fill(row, -1);
        // }
        // return solve(0, 1, prices, dp);

        // int[][] dp = new int[n + 2][2];

        // for(int ind = n - 1; ind >= 0; ind--){
        //     for(int canBuy = 1; canBuy>= 0; canBuy--){
        //          if(canBuy == 1){
        //             int buy = -prices[ind] + dp[ind + 1][0];
        //             int skip = dp[ind + 1][1];

        //             dp[ind][canBuy] = Math.max(buy, skip);
        //         }else{
        //             int sell = prices[ind] + dp[ind + 2][1];
        //             int skip = dp[ind + 1][0];

        //             dp[ind][canBuy] = Math.max(sell, skip);
        //         }
        //     }
        // }

        // return dp[0][1];

        int[] next = new int[2];  //ind+1
        int[] next2 = new int[2]; //ind+2
        for(int ind = n - 1; ind >= 0; ind--){
            int[] curr = new int[2];
            for(int canBuy = 1; canBuy>= 0; canBuy--){
                 if(canBuy == 1){
                    int buy = -prices[ind] + next[0];
                    int skip = next[1];

                    curr[canBuy] = Math.max(buy, skip);
                }else{
                    int sell = prices[ind] + next2[1];
                    int skip = next[0];

                    curr[canBuy] = Math.max(sell, skip);
                }
            }
            next2 = next;
            next = curr;
        }
        return next[1];
    }
}
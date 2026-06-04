class Solution {

    // public int climb(int n, int[] dp){
    //     if(n == 0 || n == 1) return n;

    //     if(dp[n] != -1) return dp[n];

    //     return dp[n] = climb(n-1, dp) + climb(n-2, dp);
    // }

    public int climbStairs(int n) {

        // int[] dp = new int[n+2];
        // Arrays.fill(dp, -1);

        int[] dp = new int[n+2];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i < n+2; i++){
            dp[i] = dp[i-1]+ dp[i-2];
        }

        return dp[n+1];
    }
}

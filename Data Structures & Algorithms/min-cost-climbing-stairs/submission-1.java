class Solution {

    public int climb(int[] cost, int ind, int[] dp){

        if(ind >= cost.length) return 0;

        if(dp[ind] != -1) return dp[ind];

        return dp[ind] = cost[ind] + Math.min(climb(cost, ind+1, dp), climb(cost, ind+2, dp));
    }

    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(climb(cost, 0, dp), climb(cost,1, dp));
    }
}

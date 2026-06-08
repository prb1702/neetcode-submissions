class Solution {

    public int solve(int ind1, int ind2, int m, int n, int[][] dp){

        if(ind1 == m-1 && ind2 == n-1) return 1;
        if(ind1 > m-1 || ind2 > n-1) return 0;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        int right = solve(ind1, ind2 + 1, m, n, dp);
        int down = solve(ind1 + 1, ind2, m, n, dp);

        return dp[ind1][ind2] = right + down;
    }

    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m][n];

        // for(int[] row: dp) Arrays.fill(row, -1);

        // return solve(0, 0, m, n, dp);

        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int ind1 = m-1; ind1 >= 0; ind1--){
            for(int ind2 = n-1; ind2 >= 0; ind2--){
                
                if(ind1 == m-1 && ind2 == n-1) continue;

                dp[ind1][ind2] = dp[ind1][ind2 + 1] + dp[ind1 + 1][ind2];
            }
        }
        return dp[0][0];
    }
}

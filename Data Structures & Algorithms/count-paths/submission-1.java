class Solution {

    public int solve(int ind1, int ind2, int m, int n, int[][] dp){

        if(ind1 == m && ind2 == n) return 1;
        if(ind1 > m || ind2 > n) return 0;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        int right = solve(ind1, ind2 + 1, m, n, dp);
        int down = solve(ind1 + 1, ind2, m, n, dp);

        return dp[ind1][ind2] = right + down;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] row: dp) Arrays.fill(row, -1);

        return solve(0, 0, m-1, n-1, dp);
    }
}

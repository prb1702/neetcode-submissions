class Solution {

    public int solve(int ind, String s, int[] dp){
        
        if(ind == s.length()) return 1;
        if(s.charAt(ind) == '0') return 0;

        if(dp[ind] != -1) return dp[ind];

        int ways = solve(ind + 1, s, dp);

        if(ind + 1 < s.length()){
            int num = (s.charAt(ind) - '0')*10 + (s.charAt(ind+1) - '0');

            if(num >= 10 && num <= 26){
                ways += solve(ind+2, s, dp);
            }
        }
        return dp[ind] = ways;
    }

    public int numDecodings(String s) {

        int n = s.length();

        // int[] dp = new int[n];

        // Arrays.fill(dp, -1);

        // return solve(0, s, dp);

        // base case
        // changing parameters in reverse order
        
        int[] dp = new int[n+1];

        dp[n] = 1;

        for(int ind = n-1; ind >= 0; ind--){

            if(s.charAt(ind) == '0') continue;

            int ways = dp[ind + 1];

            if(ind + 1 < s.length()){
                int num = (s.charAt(ind) - '0')*10 + (s.charAt(ind+1) - '0');

                if(num >= 10 && num <= 26){
                    ways += dp[ind+2];
                }
            }
            dp[ind] = ways;
        }

        return dp[0];
    }
}

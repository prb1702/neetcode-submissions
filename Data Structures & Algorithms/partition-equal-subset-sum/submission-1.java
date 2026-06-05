class Solution {

    public boolean solve(int ind ,int[] nums, int target, Boolean[][] dp){
        
        if(target == 0) return true;

        if(ind >= nums.length || target < 0) return false;

        if(dp[ind][target] != null) return dp[ind][target];
        
        return dp[ind][target] = solve(ind + 1, nums, target - nums[ind], dp) || solve(ind + 1, nums, target, dp);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum % 2 != 0) return false;

        // Boolean[][] dp = new Boolean[nums.length + 1][(sum/2) + 1];

        // return solve(0, nums, sum/2, dp);

        int n = nums.length;
        boolean[][] dp = new boolean[nums.length + 1][(sum/2) + 1];
        dp[n][0] = true;

        for(int ind = n-1; ind >= 0 ; ind--){
            for(int target = 0; target <= sum/2; target++){

                boolean notTake = dp[ind + 1][target];
                boolean take = false;
                if(target >= nums[ind]){
                    take = dp[ind + 1][target - nums[ind]];
                }
                dp[ind][target] = notTake || take;
            }
        }
        return dp[0][sum/2];
    }
}

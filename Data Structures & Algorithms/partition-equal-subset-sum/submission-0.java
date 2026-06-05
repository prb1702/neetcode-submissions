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

        Boolean[][] dp = new Boolean[nums.length][(sum/2) + 1];

        return solve(0, nums, sum/2, dp);
    }
}

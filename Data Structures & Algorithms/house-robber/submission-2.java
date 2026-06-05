class Solution {

    public int robHouse(int ind, int[] nums, int[] dp){
        if(ind < 0) return 0;

        if(dp[ind] != -1) return dp[ind];

        return dp[ind] = Math.max(robHouse(ind-1, nums, dp), nums[ind] + robHouse(ind-2, nums, dp));
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return robHouse(nums.length-1, nums, dp);
    }
}

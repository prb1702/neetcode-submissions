class Solution {

    public int robHouse(int ind, int end, int[] nums, int[] dp) {

        if(ind > end) return 0;

        if(dp[ind] != -1) return dp[ind];

        return dp[ind] = Math.max(robHouse(ind + 1, end, nums, dp), nums[ind] + robHouse(ind + 2, end, nums, dp));
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(robHouse(0, nums.length - 2, nums, dp1), robHouse(1, nums.length - 1, nums, dp2));
    }
}

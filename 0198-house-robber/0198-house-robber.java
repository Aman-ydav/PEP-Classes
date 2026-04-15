class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(nums,dp,n-1);
    }
    int solve(int[] nums,int[] dp,int i){
        if(i==0) return nums[i];
        if(i==1) return Math.max(nums[i],nums[i-1]);

        if(dp[i]!=-1) return dp[i];
        int skip = solve(nums,dp,i-1);
        int take = nums[i] + solve(nums,dp,i-2);

        return dp[i] = Math.max(skip,take);
    }
}
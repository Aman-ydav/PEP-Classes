class Solution {
    Integer [][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        dp = new Integer[n+1][n+2];
        for(int i=0;i<n;i++){
            int sol = solve(nums,i,-1);
            ans = Math.max(ans,sol);
        }
        return ans;
    }
    int solve(int[] nums,int i,int prev){

        if(i>=nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=null) return dp[i][prev+1];
        int take = 0;
        if(prev==-1){
            take =  1 + solve(nums,i+1,i);
        }
        else if(nums[i]>nums[prev]){
            take =  1+solve(nums,i+1,i);
        }

        int skip =  solve(nums,i+1,prev);

        return dp[i][prev+1] = Math.max(take,skip);
    }
}
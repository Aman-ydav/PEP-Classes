class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        int t = sum/2;
        int dp[][] = new int[n+1][t+1];

        for(int i=1;i<=n;i++){
            for(int j=0;j<=t;j++){
                int skip = dp[i-1][j];

                int take = 0;
                if(j-nums[i-1]>=0){
                    take = nums[i-1] + dp[i-1][j-nums[i-1]];
                }
                dp[i][j] = Math.max(take,skip);
            }
        }
        return dp[n][t]==t;
    }
}
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int range = 0;
        for(int i=0;i<n;i++){
            range+=nums[i];
        }
        if(range<Math.abs(target)) return 0;
        int s1 = (range+target)/2;
        if((range+target)%2!=0) return 0;

        int[][] dp = new int[s1+1][n+1];  

        for(int i=0;i<=n;i++){
            dp[0][i] = 1;
        } 

        for(int i=0;i<=s1;i++){
            for(int j=1;j<=n;j++){
                int skip = dp[i][j-1];
                int take = 0;
                if(i>=nums[j-1]){
                    take = dp[i-nums[j-1]][j-1];
                }
                dp[i][j] = take+skip;
            }
        }
        return dp[s1][n];
    }
}
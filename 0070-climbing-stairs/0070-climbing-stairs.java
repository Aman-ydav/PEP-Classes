class Solution {
    int dp[];
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
    int solve(int n){
        if(n==0){
            return 1;
        }
        if(dp[n]!=-1) return dp[n];

        int onestep = solve(n-1);
        int twostep = 0;

        if(n>=2) twostep = solve(n-2);

        return dp[n] = onestep+twostep;

    }
}
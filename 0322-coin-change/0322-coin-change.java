class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        dp = new Integer[amount+1][n+1];
        int a =  solve(coins,amount,n-1);
        return a==Integer.MAX_VALUE ? -1 : a;
    }
    int solve(int[] arr,int sum,int n){

        if(sum==0){
            return 0;
        }
        
        if(n<0 || sum<0){
            return Integer.MAX_VALUE;
        }

        if(dp[sum][n]!=null) return dp[sum][n];
        int take = solve(arr,sum-arr[n],n);

        if(take!=Integer.MAX_VALUE){
            take +=1;
        }
        int skip = solve(arr,sum,n-1);

        return  dp[sum][n]= Math.min(take,skip);
        
    }
}
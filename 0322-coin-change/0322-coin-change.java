class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n+1][amount+1];

        int a = solve(coins,dp,amount,n-1);

        return a==Integer.MAX_VALUE ? -1 :a;
    }
    int solve(int[] coins,Integer[][] dp,int amount,int i){
        if(amount==0){
            return 0;
        }
        if(i<0 || amount<0){
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount]!=null) return dp[i][amount]; 

        int skip = solve(coins,dp,amount,i-1);

        int take = 0;

            take = solve(coins,dp,amount-coins[i],i);
        
        if(take!=Integer.MAX_VALUE){
            take+=1;
        }

        return dp[i][amount] = Math.min(take,skip);
    }
}
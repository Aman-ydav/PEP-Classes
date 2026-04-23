class Solution {
    public int change(int amount, int[] coins) {
         int n = coins.length;
        Integer[][] dp = new Integer[n+1][amount+1];

        for(int i=0;i<=n;i++){
            dp[i][0]= 1;
        }
        int a = solve(coins,dp,amount,n-1);

        return a;
    }
    int solve(int[] coins,Integer[][] dp,int amount,int i){
        if(amount==0){
            return 1;
        }
        if(i<0 || amount<0){
            return 0;
        }
        if(dp[i][amount]!=null) return dp[i][amount]; 

        int skip = solve(coins,dp,amount,i-1);

        int take = 0;

        if(amount-coins[i]>=0)
        take = solve(coins,dp,amount-coins[i],i);
        

        return dp[i][amount] = take+skip;
    }
}
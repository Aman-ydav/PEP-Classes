class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        int bp = prices[0];
        for(int i=1;i<n;i++){
            if(prices[i]>bp){
                ans = Math.max(ans,prices[i]-bp);
            }
            else{
                bp = prices[i];
            }
        }
        return ans;
    }
}
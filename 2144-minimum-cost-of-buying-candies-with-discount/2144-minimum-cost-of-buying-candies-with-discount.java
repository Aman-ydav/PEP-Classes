class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int ans = 0;
        int c = 1;
        for(int i=n-1;i>=0;i--){

            if(c!=3){
                ans+=cost[i];
            }
            if(c==3) c=0;
            c++;

        }
        return ans;
    }
}
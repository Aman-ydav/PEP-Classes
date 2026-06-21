class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length;
        int sum =0;
        int count = 0;
        for(int i=0;i<n;i++){
            sum += costs[i];
            if(sum<=coins){
                count++;
            }
            else break;
        }
        return count;
    }
}
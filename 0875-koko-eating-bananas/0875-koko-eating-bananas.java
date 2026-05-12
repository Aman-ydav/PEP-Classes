class Solution {
    public int minEatingSpeed(int[] piles, int max) {
        int n = piles.length;
        int l = 1;
        int h = 0;
        for(int i=0;i<n;i++){
            h = Math.max(piles[i],h);
        }
        int ans = 0;
        while(l<=h){
            int m = l+(h-l)/2;
            if(solve(piles,m,max)){
                ans = m;
                h = m - 1;
            }
            else{
                l = m +1;
            }
        }
        return ans;
    }
    boolean solve(int[] arr,int speed,int h){

        int n = arr.length;
        long count=0;
        for(int i=0;i<n;i++){
            int a = (int) Math.ceil(((double)arr[i])/((double)speed));
            count+=a;
        }
        if(count<=h) return true;
        return false;
    }
}
class Solution {
    public int splitArray(int[] nums, int k) {
        int n  = nums.length;
        int min = 0;
        int max = 0;
        for(int a : nums){
            max += a;
        }
        if(k>n) return -1;
        int ans = -1;
        while(min<=max){
            int mid = min+(max-min)/2;

            if(isValid(nums,k,mid)){
                ans = mid;
                max = mid-1;
            }
            else{
                min = mid + 1;
            }
        }
        return ans;
    }
    boolean isValid(int[] nums,int k,int mid){
        int n = nums.length;
        int sum =0;
        int x =1;
        for(int i=0;i<n;i++){
            if(mid<nums[i]) return false;
            if(sum+nums[i]<=mid){
                sum+=nums[i];
            }
            else{
                x++;
                sum = nums[i];
            }
        }
        return x<=k;
    }
}
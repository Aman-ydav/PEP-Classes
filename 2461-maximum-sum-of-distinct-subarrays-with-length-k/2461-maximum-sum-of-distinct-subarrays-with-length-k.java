class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        int l=0;
        long sum=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            sum+=nums[i];
            if(i-l+1>k){
                sum-=nums[l];
                set.remove(nums[l]);
                l++;
            }
            while(set.contains(nums[i])){
                sum-=nums[l];
                set.remove(nums[l]);
                l++;
            }
            if(i-l+1==k)
            ans = Math.max(sum,ans); 
            set.add(nums[i]);
        }
        return ans;
    }
}
class Solution {
    public int findPeakElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        int idx =-1;
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            max = Math.max(max,n);
            if(max==n){
                idx = i;
            }
        }
        return idx;
    }
}
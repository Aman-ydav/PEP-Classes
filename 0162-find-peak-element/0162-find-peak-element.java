class Solution {
    public int findPeakElement(int[] nums) {
        int i=0;
        int j = nums.length-1;
        int n = nums.length;
        if(n==1) return 0;
        while(i<=j){
            int m = i+(j-i)/2;
            if(m+1==n && m-1>=0 && nums[m]>nums[m-1]){
                return m;
            }
            else if(m-1==-1 && m+1<n && nums[m]>nums[m+1]){
                return m;
            }
            else if(m-1>=0 && m+1<n && nums[m]>nums[m-1] && nums[m]>nums[m+1]){
                return m;
            }
            else if(m-1>=0 && nums[m]<nums[m-1]){
                j = m-1;
            }
            else{
                i = m+1;
            }
            
        }
        return -1;
    }
}
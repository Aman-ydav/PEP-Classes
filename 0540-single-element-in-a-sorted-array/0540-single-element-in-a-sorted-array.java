class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        
        int i=0;
        int j = n-1;
        if(n==1) return nums[0];

        while(i<=j){
            int m = i+(j-i)/2;
            if(m%2==0){
                if(m+1<n && nums[m]==nums[m+1]){
                    i = m+1;
                    continue;
                }
                else if(m>0 && nums[m]==nums[m-1]){
                    j = m-1;
                    continue;
                }
                else{
                    return nums[m];
                }
            }
            else {
                

                if(m>0 && nums[m]==nums[m-1]){
                    i = m+1;
                    continue;
                }
                else if(m+1<n && nums[m]==nums[m+1]){
                    j = m-1;
                    continue;
                }
                else{
                    return nums[m];
                }
            }
        }
        return -1;
    }
}
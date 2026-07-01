class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int cand = -1;
        for(int i=0;i<n;i++){
            if(count==0){
                cand = nums[i];
            }
            if(nums[i]==cand){
                count++;
            }
            else{
                count--;
            }
        }
        int c = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==cand){
                c++;
            }  
        }
            
        return c>=n/2 ? cand : -1;
        
    }
}
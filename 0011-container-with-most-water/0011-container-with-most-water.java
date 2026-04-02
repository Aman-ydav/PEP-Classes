class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length;
        
        int i=0;
        int j=n-1;
        int max = 0;
        
        while(i<j){

            int l = j-i;
            int h = Math.min(nums[i],nums[j]);
            max = Math.max(max,l*h);

            if(nums[i]>nums[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return max;
    }
}
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        
        int i = 0;
        int m = 0;
        int j = n-1;

        while(m<=j){
            if(nums[m]==0){
                nums[m] = nums[i];
                nums[i] = 0;
                m++;
                i++;
            }
            else if(nums[m]==1){
                m++;
            }
            else{
                nums[m] = nums[j];
                nums[j] = 2;
                j--;
            }
        }
    }
}
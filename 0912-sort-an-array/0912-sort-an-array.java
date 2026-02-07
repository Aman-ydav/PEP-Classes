class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }
    void sort(int[] nums,int s,int e){
        if(s>=e){
            return;
        }
        int mid = s+(e-s)/2;
        sort(nums,s,mid);
        sort(nums,mid+1,e);
        merge(nums,s,mid,e);
    }
    void merge(int[] nums,int s,int mid,int e){
        int i = s;
        int j = mid+1;
        int[] arr = new int[e-s+1];
        int k = 0;
        while(i<=mid && j<=e){
            if(nums[i]<nums[j]){
                arr[k] = nums[i];
                i++;
            }
            else {
                arr[k] = nums[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            arr[k] = nums[i];
            i++;
            k++;
        }
        while(j<=e){
            arr[k++] = nums[j++];
        }
        int y = s;
        for(int x=0;x<arr.length;x++){
            nums[s++] = arr[x];
        }
    }
    
}
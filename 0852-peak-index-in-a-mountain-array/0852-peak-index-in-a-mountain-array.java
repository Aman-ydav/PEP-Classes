class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n-1;
        
        while(i<=j){
            int m = i+(j-i)/2;
            if(m+1<n && m-1>=0 && arr[m]>arr[m+1] && arr[m]>arr[m-1]){
                return m;
            }
            
            if(m+1<n && arr[m]<arr[m+1]){
                i = m+1;
            }
            else{
                j = m-1;
            }
        }
        return -1;
    }
}
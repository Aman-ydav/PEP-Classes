class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m1 = matrix[0].length;
        int rs=0;
        int re= n-1;
        int cs =0;
        int ce = m1-1;
        while(rs<=re){
            int m = rs+(re-rs)/2;
            if(matrix[m][ce]>=target && matrix[m][cs]<=target){
                int i = 0;
                int j = m1-1;
                while(i<=j){
                    int mid = i+(j-i)/2;
                    if(matrix[m][mid]==target) return true;
                    else if(matrix[m][mid]>target){
                        j = mid-1;
                    }
                    else{
                        i = mid+1;
                    }
                }
                return false;
            }
            else if(matrix[m][ce]>target){
                re = m-1;
            }
            else{
                rs = m+1;
            }
        }
        return false;
    }
}
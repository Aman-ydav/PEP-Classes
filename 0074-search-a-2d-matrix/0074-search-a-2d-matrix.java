class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int i =0;
        int j = n-1;
        while(i<=j){
            int mid = i+(j-i)/2;

            if(matrix[mid][m-1]>=target){  
                if(matrix[mid][0]<=target){
                    int a = 0;
                    int b = m-1;
                    while(a<=b){
                        int md = a+(b-a)/2;
                        if(matrix[mid][md]==target){
                            return true;
                        }
                        else if(matrix[mid][md]>target){
                            b = md-1;
                        }
                        else{
                            a = md+1;
                        }
                    }
                    return false;
                }
                else{
                    j = mid-1;
                }
            }   
            else{
                i = mid+1;
            }
        }
        return false;
    }
}
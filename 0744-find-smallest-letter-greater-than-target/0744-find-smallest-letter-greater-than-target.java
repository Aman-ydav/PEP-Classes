class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];
        
        int i = 0;
        int j = letters.length-1;
        while(i<=j){
            int m = i+(j-i)/2;
            if(letters[m]>target){ 
                ans = letters[m];
                j = m - 1;
            }
            else{
                i = m + 1;
            }
        }
        return ans;
    }
}
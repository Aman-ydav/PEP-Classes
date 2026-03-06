class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int x=n-1;
        while(x>=0 && s.charAt(x)=='0'){
            x--;
        }
        int i=x;
        if(s.length()==1){
            return true;
        }
        boolean pvt = false;
        while(i>=0){

            if(pvt){
                return false;
            }
            if(s.charAt(i)=='0'){
                pvt = true;
            }
            i--;
        }
        return true;

    }
}
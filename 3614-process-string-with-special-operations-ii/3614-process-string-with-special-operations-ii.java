class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n];
        long l = 0;
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='*'){
                l = Math.max(0,l-1);
            }
            else if(s.charAt(i)=='#'){
                l*=2;
            }
            else if(s.charAt(i)=='%'){
                // continue;
            }
            else{
                l++;
            }
            len[i] = l;
        }
        if(k>=l) return '.';
        

        for(int i=n-1;i>=0;i--){
            long currlen = len[i];
            long prevlen = (i==0) ? 0 : len[i-1];
            if(s.charAt(i)=='*'){
               currlen += 1;
            }
            else if(s.charAt(i)=='#'){
                k = k % prevlen;
            }
            else if(s.charAt(i)=='%'){
                k = currlen - k - 1;
            }
            else{
                if(k==currlen-1){
                    return s.charAt(i);
                }
            }
        }
        return '.';
    }
}
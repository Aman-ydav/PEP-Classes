class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        if(s.charAt(0)=='0') return 0;
        if(n==1) return 1;
        dp[0] = 1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)!='0'){
                dp[i] += dp[i-1];
            }

            int twodigit = (s.charAt(i-1)-'0')*10 + s.charAt(i)-'0';

            if(twodigit>=10 && twodigit<=26){
                if(i==1){
                    dp[i] +=1;
                }
                else{
                    dp[i] += dp[i-2];
                }
            }

        }
        return dp[n-1];
    }
}
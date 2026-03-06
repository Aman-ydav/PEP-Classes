class Solution {
    public int minOperations(String s) {
        int a = check(s,'0');
        int b = check(s,'1');
        return Math.min(a,b);
    }
    int check(String s,char start){
        int n = s.length();
        int i = n-1;
        int count =0;
    
        while(i>=0){
            
            int exp = (i%2==0) ? start : (start=='1' ? '0' : '1');

            if(exp!=s.charAt(i)){
                count++;
            }
            i--;
        }
        return count;
    }
}
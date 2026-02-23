class Solution {
    public int binaryGap(int n) {
        int count = 0;
        int max = 0;
        int x = n;
        int last = -1;
        while(n>0){
            int bit = n & 1;
            if(bit==1){
               if(last!=-1){
                max = Math.max(max,count-last);
               }
               last = count;
            }
            count++;
            n = n >> 1;
        }
        return max;
    }
}
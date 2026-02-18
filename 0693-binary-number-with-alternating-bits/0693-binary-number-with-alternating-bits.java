class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = -1;
        while(n>0){
            int bit = n&1;
            if(prev==bit){
                return false;
            }
            prev = bit;
            n = n >> 1;
        }
        return true;
    }
}
class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int gains = 0;
        for(int i=0;i<gain.length;i++){
            gains += gain[i];
            max = Math.max(max, gains);
        }
        return max;
    }
}
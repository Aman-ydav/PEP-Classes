class Solution {
    public double angleClock(int hour, int minutes) {
        double ans =  Math.abs((30 * (double)hour - 5.5 * (double)minutes ));
        double reflex = 360 - ans;
 
        return Math.min(reflex,ans);
    }
}
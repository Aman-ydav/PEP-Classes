class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans1 = calculate(landStartTime, landDuration,
                             waterStartTime, waterDuration);

        int ans2 = calculate(waterStartTime, waterDuration,
                             landStartTime, landDuration);

        return Math.min(ans1, ans2);
    }

    private int calculate(int[] start1, int[] duration1,
                          int[] start2, int[] duration2) {

        int minEnd = Integer.MAX_VALUE;

        for (int i = 0; i < start1.length; i++) {
            minEnd = Math.min(minEnd, start1[i] + duration1[i]);
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < start2.length; i++) {
            result = Math.min(
                result,
                Math.max(minEnd, start2[i]) + duration2[i]
            );
        }

        return result;
    }
}
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int cand1 = -1, cand2 = -1, count1 = 0, count2 = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == cand1) {
                count1++;
            } else if (nums[i] == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == cand1) {
                c1++;
            }
            if (nums[i] == cand2) {
                c2++;
            }
        }

        if (c1 > n / 3) {
            list.add(cand1);
        }
        if (c2 > n / 3) {
            list.add(cand2);
        }
        if (cand1 == cand2) {
            list.remove(1);
        }

        return list;
    }
}
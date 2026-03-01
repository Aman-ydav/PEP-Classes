class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int x: nums){
            set.add(x);
        }
        int max = 0;
        for(int num: set){
            if(!set.contains(num-1)){
                int count = 1;
                int a = num;
                while(set.contains(a+1)){
                    count++;
                    a++;
                }
                max = Math.max(count,max);
            }
        }
        return max;
    }
}
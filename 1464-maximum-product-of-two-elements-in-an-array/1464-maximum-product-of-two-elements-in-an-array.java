class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(nums[i]);
        }
        
        return (pq.remove()-1)*(pq.remove()-1);
    }
}
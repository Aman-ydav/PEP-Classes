class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        int ans =-1;
        int x=1;
        while(!pq.isEmpty() && x<=k){
           ans =  pq.remove();
           x++;
        }
        return ans;
    }
}
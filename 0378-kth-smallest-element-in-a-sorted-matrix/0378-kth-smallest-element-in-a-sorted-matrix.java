class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pq.add(matrix[i][j]);
            }
        }
        int ans = -1;
        int x = 1;
        while(!pq.isEmpty() && x<=k){
            ans = pq.remove();
            x++;
        }
        return ans;
    }
}
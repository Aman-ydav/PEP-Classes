class Solution {
    class row implements Comparable<row> {
        int r;
        int soldier;
        public row(int r,int soldier){
            this.r=r;
            this.soldier = soldier;
        }
        @Override
        public int compareTo(row p2){
            if(this.soldier==p2.soldier){
                return this.r-p2.r;
            }
            return this.soldier-p2.soldier;
        }

    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<row> pq = new PriorityQueue<>();
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<n;i++){
            int s = 0;
            for(int j=0;j<m;j++){
                if(mat[i][j]==1) s+=1;
            }
            pq.add(new row(i,s));
        }
        int x=0;
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            arr[x++] = pq.remove().r;
        }
        return arr;
    }
}
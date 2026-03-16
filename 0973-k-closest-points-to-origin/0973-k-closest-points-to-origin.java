class Solution {
    class Point{
        int x;
        int y;
        int sq;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
            sq = x*x + y*y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
       
        int n = points.length;
        PriorityQueue<Point> pq = new PriorityQueue<>((p,q) -> (p.sq-q.sq));
        int[][] ans = new int[k][2];

        for(int i=0;i<n;i++){
            pq.add(new Point(points[i][0],points[i][1]));
        }
        int x = 0;
        int a = 0;
        while(!pq.isEmpty() && x<k){
            Point p = pq.remove();
            ans[a][0] = p.x;
            ans[a++][1] = p.y;
            x++;
        }
        
        return ans;
    }
}
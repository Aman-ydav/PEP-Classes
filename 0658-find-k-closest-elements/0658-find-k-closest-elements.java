class Solution {
    class point{
        int x;
        int a;
        int diff;
        public point(int a,int x){
            this.x = x;
            this.a = a;
            diff = Math.abs(a-x);
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        PriorityQueue<point> pq = new PriorityQueue<>(
            (p, q) -> {
            if (p.diff != q.diff) {
                return Integer.compare(p.diff, q.diff);
            }
            return Integer.compare(p.a, q.a); 
        }
        );
        for(int i=0;i<n;i++){
            pq.add(new point(arr[i],x));
        }
        int j = 1;
        while(!pq.isEmpty() && j<=k){
            list.add(pq.remove().a);
            j++;

        }
        Collections.sort(list);
        return list;
    }
}
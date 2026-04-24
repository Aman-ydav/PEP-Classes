class Solution {
    class Pair{
         int position;
         double time;
        public Pair(int position,double time){
            this.position = position;
            this.time = time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int distance_rem[] = new int[n];

        Pair[] cars = new Pair[n];
        for(int i=0;i<n;i++){
            double t = (double)(target-position[i]);
            double ti = t/(double)speed[i];
            cars[i] = new Pair(position[i],ti);
            // System.out.println(ti);
        }

        Arrays.sort(cars,(a,b)->b.position-a.position);

        Stack<Integer> s = new Stack<>();

        int fleet=0;
        double prevtime=0;    

        for(Pair car : cars){
            // System.out.print(car.time+" ");
           if(car.time>prevtime){
                fleet++;
                prevtime = car.time;
           }
        }

        return fleet;
    }
}
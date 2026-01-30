class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        int diff = 0;
        int start = 0;
        for(int i=0;i<n;i++){
            total += gas[i]-cost[i];
            diff += gas[i]-cost[i];

            if(diff<0){
                start = i+1;
                diff = 0;
            }
        }
        if(total<0) return -1;
        return start;
    }
}
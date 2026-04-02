class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int mindiff = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            mindiff = Math.min(mindiff,Math.abs(arr[i]-arr[i+1]));
        }
        for(int i=0;i<n-1;i++){
            List<Integer> l = new ArrayList<>();
            if(Math.abs(arr[i]-arr[i+1])==mindiff){
                l.add(arr[i]);
                l.add(arr[i+1]);
            list.add(l);
            }
        }
        return list;
    }
}
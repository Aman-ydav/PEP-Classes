class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])  return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] arr = new int[n];

        Arrays.fill(arr,-1);
        int len = 0;
        for(int a[] : envelopes){
            int h = a[1];
            int idx =  Arrays.binarySearch(arr,0,len,h);
            if(idx<0){
                idx = -(idx+1);
            }
            arr[idx]= h;
            if(idx==len) len++;
        }
        return len;
    }
}
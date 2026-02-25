class Solution {
    public int[] sortByBits(int[] arr) {
        int[][] a = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            int n = arr[i];
            int bits = Integer.bitCount(n);
            a[i][0] = bits;
            a[i][1] = n;
        }
        int x =0;
        Arrays.sort(a,(c,b)->{
            if(c[0]==b[0]){
                return c[1]-b[1];
            }
            return c[0]-b[0];
        });
        for(int i=0;i<a.length;i++){
            arr[i] = a[i][1];
        }
        return arr;
    }
}
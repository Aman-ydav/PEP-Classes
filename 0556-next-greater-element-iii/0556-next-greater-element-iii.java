class Solution {
    public int nextGreaterElement(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int a = n;
        while(a>0){
            int d = a%10;
            arr.add(d);
            a/=10;
        }
        int num = arr.size();
        Collections.reverse(arr);

        int pvt = -1;
        for(int i=num-2;i>=0;i--){
            if(arr.get(i)<arr.get(i+1)){
                pvt = i;
                break;
            }
        }
        if(pvt==-1) return -1;

        for(int i=num-1;i>pvt;i--){
            if(arr.get(pvt)<arr.get(i)){
                int temp = arr.get(pvt);
                arr.set(pvt,arr.get(i));
                arr.set(i,temp);
                break;
            }
        }

        
        int i = pvt+1;
        int j = num-1;

        while(i<=j){
            int temp = arr.get(i);
            arr.set(i,arr.get(j));
            arr.set(j,temp);
            j--;
            i++;
        }
        int ans =0;

        for(int k=0;k<num;k++){
            if(ans > (Integer.MAX_VALUE - arr.get(k)  ) /10  ){
                return -1;
            }
            ans = ans*10+arr.get(k);
        }
        return ans;
    }
}
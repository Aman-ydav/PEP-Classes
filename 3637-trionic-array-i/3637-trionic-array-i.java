class Solution {
    public boolean isTrionic(int[] arr) {
        int p=0;
        if(arr.length<4) return false;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                p=i+1;
            }
            else break;
        }
        if(p==0) return false;
        int q=arr.length-1;
         for(int i=p;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                q=i+1;
            }
            else break;
        }
        if(q==arr.length-1) return false;
        // System.out.print(p+" "+q);
        for(int i=p;i<q-1;i++){
            if(arr[i]<=arr[i+1]){
                return false;
            } 
        }
        for(int i=0;i<p-1;i++){
            if(arr[i]>=arr[i+1]){
                return false;
            } 
        }
        for(int i=q;i<arr.length-1;i++){
            if(arr[i]>=arr[i+1]){
                return false;
            } 
        }          
        return true;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] ps = new int[n];
        int[] ns = new int[n];
        Stack<Integer> s = new Stack<>();
        ps[0] = -1;
        s.push(0);
        for(int i=1;i<n;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ps[i]=-1;
            }
            else{
                ps[i] = s.peek();
            }
            s.push(i);
        }

       
        s.clear();
        ns[n-1] = n;
        s.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ns[i] = n;
            }
            else{
                ns[i] = s.peek();
            }
            s.push(i);
        }
      
        int ans=0;
        for(int i=0;i<n;i++){
            int h = heights[i];
            int w = ns[i]-ps[i]-1;
            ans = Math.max(ans,h*w);
        }
        return ans;
    }
}
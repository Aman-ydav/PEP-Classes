class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        int[] nse = new int[n];
        int[] pse = new int[n];
        int x =0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[x++] = -1;
            }
            else{
                pse[x++] = st.peek();
            }
            st.push(i);
        }

        st.clear();
        x = n-1;

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[x--] = n;
            }
            else{
                nse[x--] = st.peek();
            }
            st.push(i);
        }


        for(int i=0;i<n;i++){
            int width = nse[i]-pse[i]-1;
            int curr = heights[i] * width;
            ans = Math.max(ans,curr);
        }
        return ans;
    }
}
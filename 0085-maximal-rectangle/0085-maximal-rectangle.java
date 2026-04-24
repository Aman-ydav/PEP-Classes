class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int arr[] = new int[m];
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='0') arr[j] = 0;
                else arr[j] += matrix[i][j]-'0';
            }
            max = Math.max(max,histogram(arr));
        }
        return max;
    }
    int histogram(int[] arr){
        int n = arr.length;

        Stack<Integer> s = new Stack<>();

        int[] ps = new int[n];
        int[] ns = new int[n];

        for(int i=0;i<n;i++){
            
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()) ps[i] = -1;
            else{
                ps[i] = s.peek();
            }
            s.push(i);
        }
        s.clear();

        for(int i=n-1;i>=0;i--){
            
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()) ns[i] = n;
            else{
                ns[i] = s.peek();
            }
            s.push(i);
        }
        int max =0;

        for(int i=0;i<n;i++){
            int h = arr[i];
            int w = ns[i]-ps[i]-1;
            max = Math.max(max, h * w);
        }

        return max;
    }
}
class MinStack {
    Stack<int[]> s;
    
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        
        int[] arr = new int[2];
        arr[0] = val;
        
        if(s.isEmpty()){
            arr[1] = val;
        }
        else{
            arr[1] = Math.min(s.peek()[1],val);
        }
        s.push(arr);

    }
    
    public void pop() {
        if(!s.isEmpty()){
            s.pop();
        }
    }
    
    public int top() {
        if(s.isEmpty()){
            return -1;
        }
        return s.peek()[0];
    }
    
    public int getMin() {
        return s.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
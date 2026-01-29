class MinStack {
    Stack<Integer> s;
    Stack<Integer> min;
    public MinStack() {
        s = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(min.isEmpty()) min.push(val);
        else if(val<=min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        int val = s.pop();
        if(val==min.peek()) min.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() { 
        if(!min.isEmpty())  return min.peek();
        return 0;
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
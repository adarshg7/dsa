class MinStack {
    Stack<Long> s = new Stack<>();
    long min;
    public MinStack() {
        
    }
    
    public void push(int value) {
        if(s.isEmpty()) {
            s.push((long)value);
            min = value;
        }else if(value < min) {
            s.push(2L*value - min);
            min = value;
        }else{
            s.push((long)value);
        }
    }
    
    public void pop() {
        long t = s.pop();
        if(t < min) min = 2*min - t;
    }
    
    public int top() {
        long t = s.peek();
        return t < min ? (int)min : (int)t;
    }
    
    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MyQueue {
    Stack<Integer> st;
    Stack<Integer> st2;
    public MyQueue() {
        st = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        if(st.isEmpty()) return -1;
        while(!st.isEmpty()){
            st2.push(st.pop());
        }

        int ans = st2.pop();
        while(!st2.isEmpty()){
            st.push(st2.pop());
        }

        return ans;
    }
    
    public int peek() {
        if(st.isEmpty()) return -1;
        while(!st.isEmpty()){
            st2.push(st.pop());
        }

        int ans = st2.pop();
        st2.push(ans);

        while(!st2.isEmpty()){
            st.push(st2.pop());
        }

        return ans;
    }
    
    public boolean empty() {
        if(st.isEmpty()) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

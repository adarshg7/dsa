import java.util.*;

class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        if(!q1.isEmpty()){
            int a = q1.size();

            for(int i =0; i < a - 1; i++){
                q2.offer(q1.poll());
            }

            int ans = q1.poll();

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            
            return ans;
        }else{
            return -1;
        }
    }
    
    public int top() {
        if(!q1.isEmpty()){
            int a = q1.size();

            for(int i =0; i < a - 1; i++){
                q2.offer(q1.poll());
            }

            int ans = q1.peek();
            q2.offer(q1.poll());

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            
            return ans;
        }else{
            return -1;
        }
    }
    
    public boolean empty() {
        if(q1.isEmpty()) return true;
        else return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */


//Or

import java.util.*;

class MyStack {

    Queue<Integer> q1;

    public MyStack() {
        q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        if(!q1.isEmpty()){
            int a = q1.size();

            for(int i =0; i < a - 1; i++){
                q1.offer(q1.poll());
            }

            int ans = q1.poll();
            
            return ans;
        }else{
            return -1;
        }
    }
    
    public int top() {
        if(!q1.isEmpty()){
            int a = q1.size();

            for(int i =0; i < a - 1; i++){
                q1.offer(q1.poll());
            }

            int ans = q1.peek();
            q1.offer(q1.poll());

            return ans;
        }else{
            return -1;
        }
    }
    
    public boolean empty() {
        if(q1.isEmpty()) return true;
        else return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

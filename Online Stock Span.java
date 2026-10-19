class StockSpanner {
    Stack<Integer> st;
    ArrayList<Integer> list;
    public StockSpanner() {
        st = new Stack<>();
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        int i = list.size() - 1;

        while(!st.isEmpty() && list.get(st.peek()) <= price){
            st.pop();
        }

        int span;

        if(st.isEmpty()){
            span = i + 1;
        }else{
            span = i - st.peek();
        }

        st.push(i);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

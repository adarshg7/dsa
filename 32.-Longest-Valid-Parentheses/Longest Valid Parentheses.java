class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int count = 0;
        for(int j = 0; j < s.length(); j++) {
            if(s.charAt(j) == '(') {
                st.push(j);
            } 
            else {
                st.pop();
                if(st.isEmpty()) {
                    st.push(j);
                } 
                else {
                    count = Math.max(count, j - st.peek());
                }
            }
        }

        return count;
    }
}

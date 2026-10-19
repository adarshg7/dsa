class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                st.push(c);
                ans = Math.max(ans,st.size());
            }else if(c == ')'){
                st.pop();
            }
        }

        return ans;
    }
}

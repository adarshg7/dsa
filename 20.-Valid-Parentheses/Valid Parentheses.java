class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        if(s.length() > 1){
            st.push(s.charAt(0));
        }else{
            return false;
        }

        for(int i = 1; i < s.length(); i++){
            if(!st.isEmpty() && ((s.charAt(i) == ')' && st.peek() == '(' ) || (s.charAt(i) == ']' && st.peek() == '[' )|| (s.charAt(i) == '}' && st.peek() == '{') )){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }

        if(st.isEmpty()) return true;
        return false;
    }
}

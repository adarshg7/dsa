class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        Stack<Character> st = new Stack<>();
        st.push('(');
        int prev = 0;
        for(int i = 1; i< s.length(); i++){

            if(s.charAt(i) == '('){
                st.push('('); 
            }else if(s.charAt(i) == ')'){
                char c = st.pop();
                if(st.isEmpty() == true){
                    sb.append(s.substring(prev + 1,i));
                    prev = i+1;
                }
                
            }
        }
        return sb.toString();
    }
}

//or

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(') {
                if(depth > 0) {
                    sb.append('(');
                }
                depth++;
            }
            else {
                depth--;

                if(depth > 0) {
                    sb.append(')');
                }
            }
        }

        return sb.toString();
    }
}

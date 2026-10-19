class Solution {
    public int minAddToMakeValid(String s) {
        if(s == null || s.length() == 0) return 0;
       
        int count = 0;
        int i = 0;
        Stack<Integer> st = new Stack<>();
        while(i < s.length() && s.charAt(i) == ')') {
            i++;
            count++;
        }

        for(int  j =  i; j <s.length(); j++){
            if(s.charAt(j)=='(') st.push(j);
            else {
                if(st.isEmpty() == false){
                    int val = st.pop();
                    if(val < j){
                        continue;
                    }
                }else{
                    count++;
                }
                
            }
        } 
        count += st.size();

        return  count;
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(); 
        f(sb,n,list,0, 0, 0);
        return list;
    }

    public void f(StringBuilder sb ,int n , List<String> list,int i, int a1, int b1 ){
        if(i >= n*2){
            if(a1==b1){
                list.add(sb.toString());
            }
            return;
        }

        if(a1 < n){
            sb.append("(");
            f(sb,n,list,i+1,a1+1,b1);
            sb.setLength(sb.length() - 1);
        }
        

        if (b1 < a1) {
            sb.append(")");

            f(sb, n, list, i + 1, a1, b1 + 1);

            sb.setLength(sb.length() - 1);
        }
    }
}

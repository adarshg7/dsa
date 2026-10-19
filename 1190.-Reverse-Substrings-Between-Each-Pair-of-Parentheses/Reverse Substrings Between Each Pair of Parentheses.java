class Solution {

    class Result {
        StringBuilder str;
        int index;

        Result(StringBuilder str, int index) {
            this.str = str;
            this.index = index;
        }
    }

    String s;

    public String reverseParentheses(String s) {
        this.s = s;

        Result res = f(0);

        return res.str.toString();
    }

    public Result f(int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = k; i < s.length(); i++) {
            if (s.charAt(i) == '(') {

                Result res = f(i + 1);
                sb.append(res.str);
                i = res.index;

            }

            else if (s.charAt(i) == ')') {

                sb.reverse();

                return new Result(sb, i);
            }
            else {

                sb.append(s.charAt(i));
            }
        }

        return new Result(sb, s.length());
    }
}

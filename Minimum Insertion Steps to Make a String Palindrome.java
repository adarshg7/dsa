class Solution {
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String s2 = sb.toString();
        int dp[][] = new int[s.length()+1][s.length()+1];
        for(int i = 1; i<=s.length(); i++){
            for(int j = 1; j<=s.length(); j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int max = dp[s.length()][s.length()];
        return s.length()- max;
    }
}

class Solution {
    public int minCut(String s) {
        int n = s.length();

     boolean dp[][] = new boolean[n][n];

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 2 || dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                }
                
            }
        }

        int memo[]= new int[n];
        Arrays.fill(memo,-1);


        return f(0,n,s, dp,memo) - 1;


        
    }

    public int f(int i , int n , String str,boolean dp[][], int memo[]){
        if( i == n) return 0;

        if (memo[i] != -1)
        return memo[i];
        int minCost = Integer.MAX_VALUE;

        for(int j = i; j<n; j++){
            if(dp[i][j]){
                int cost = 1 + f(j + 1, n, str, dp,memo);
                minCost = Math.min(minCost,cost);
            }
        }
        memo[i] = minCost;
        return minCost;
    }

    
}

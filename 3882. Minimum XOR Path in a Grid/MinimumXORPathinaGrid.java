class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean dp[][][] = new boolean[n][m][1024];

        dp[0][0][grid[0][0]] = true;

        for(int i = 0; i<n; i++){
            for(int j = 0; j < m; j++){

                if( i == 0 && j == 0) continue;

                for(int k = 0; k <= 1023; k++){
                    
                    if( i > 0 && dp[i-1][j][k]){
                        dp[i][j][k^grid[i][j]] = true;
                    }

                    if(j > 0 && dp[i][j-1][k]){
                        dp[i][j][k^grid[i][j]] = true;
                    }
                }
            }
        }

        for(int i =0; i < 1024; i++){
            if(dp[n-1][m-1][i]){
                return i;
            }
        }

        return -1;
    }
}

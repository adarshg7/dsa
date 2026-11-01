class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];

        for(int i =0; i< m; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i <n; i++){
            for(int j = 0; j < m; j++){

                int l = Integer.MAX_VALUE;
                int r = Integer.MAX_VALUE;
                int u = Integer.MAX_VALUE;

                if(j - 1 >= 0){
                    l = dp[i-1][j-1];
                }

                if(j + 1 < n){
                    r = dp[i-1][j+1];
                }

                u = dp[i-1][j];


                dp[i][j] = Math.min(r,Math.min(l,u)) + matrix[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i<m; i++){
            min = Math.min(dp[n-1][i],min);
        }

        return min;
    }
}

class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int [][][]dp = new int[rows][cols][cols];

        for(int j1 = 0; j1 < cols; j1++){
            for(int j2 = 0; j2 < cols; j2++){
                dp[rows - 1][j1][j2] = grid[rows - 1][j1];

                if(j1 != j2){
                    dp[rows - 1][j1][j2] += grid[rows -1][j2];
                }
            }
        }

        for(int i = rows - 2; i >= 0; i--){
            for(int j1 = 0; j1 < cols; j1++){
                for(int j2 = 0; j2 < cols; j2++){
                    int cherries = grid[i][j1];

                    if(j1 != j2){
                        cherries += grid[i][j2];
                    }

                    int maxNext = 0;

                    for(int d1 = -1; d1 <= 1; d1++){
                        for(int d2 = -1; d2 <= 1; d2++){

                            int nj1 = j1 + d1;
                            int nj2 = j2 + d2;

                            if(nj1 >= 0 && nj1 < cols && nj2 >= 0 && nj2 < cols){

                                maxNext = Math.max(maxNext, dp[i+1][nj1][nj2]);
                            }
                        }
                    }
                    dp[i][j1][j2] = cherries + maxNext;
                }
            }
        }

        return dp[0][0][cols - 1];
    }
}

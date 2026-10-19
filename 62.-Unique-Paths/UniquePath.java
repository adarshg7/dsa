class Solution {
    public int uniquePaths(int m, int n) {
        int mat[][] = new int[m][n];
        Arrays.fill(mat[0],1);
        for(int i = 0; i<m; i++){
            mat[i][0] = 1;
        }
        for(int i = 1; i<m; i++){
            for(int j =1; j<n; j++){
                mat[i][j] = mat[i-1][j] + mat[i][j-1];
            }
        }
        return mat[m-1][n-1];
    }
}

//or

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i =0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(0,0,m,n, dp);
    }

    public int f(int i , int j, int m , int n, int dp[][]){
        if( i >= m || j >= n) return 0;
        if(i == m - 1 || j == n - 1) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] =  f( i + 1, j, m , n, dp) + f(i, j + 1, m, n, dp);
    }
}

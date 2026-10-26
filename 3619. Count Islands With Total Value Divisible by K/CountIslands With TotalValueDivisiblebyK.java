class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0){
                    if(dfs(grid,i,j, n, m) % k == 0){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public long dfs(int grid[][], int i, int j, int n, int m){

        if(i < 0 || i >= n || j < 0 || j >= m){
            return 0;
        }

        if(grid[i][j] == 0) return 0;
        long val = grid[i][j];
        grid[i][j] = 0;

        long up = dfs(grid,i-1,j,n,m);
        long down = dfs(grid,i+1,j,n,m);
        long left = dfs(grid,i,j-1,n,m);
        long right = dfs(grid,i,j+1,n,m);
        
        return val + up + down + left + right;
    }
}

class Solution {
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int mod = 1_000_000_007;

        long[][] right = new long[n][m];
        long[][] down = new long[n][m];

        right[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i == n - 1 && j == m - 1) {
                    return (int)((right[i][j] + down[i][j]) % mod);
                }

                if (grid[i][j] == 0) {

                    long total = (right[i][j] + down[i][j]) % mod;

                    if (j + 1 < m) {
                        right[i][j + 1] =
                            (right[i][j + 1] + total) % mod;
                    }

                    if (i + 1 < n) {
                        down[i + 1][j] =
                            (down[i + 1][j] + total) % mod;
                    }

                } else {

                    if (i + 1 < n) {
                        down[i + 1][j] =
                            (down[i + 1][j] + right[i][j]) % mod;
                    }

                    if (j + 1 < m) {
                        right[i][j + 1] =
                            (right[i][j + 1] + down[i][j]) % mod;
                    }
                }
            }
        }

        return 0;
    }
}

import java.util.*;

class Solution {

    public List<List<String>> partition(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        // Precompute palindrome table
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {

                    if (j - i <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }

                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        solve(0, s, dp, path, res);

        return res;
    }

    public void solve(int idx, String s,
                      boolean[][] dp,
                      List<String> path,
                      List<List<String>> res) {

        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < s.length(); i++) {

            if (dp[idx][i]) {

                path.add(s.substring(idx, i + 1));

                solve(i + 1, s, dp, path, res);

                path.remove(path.size() - 1);
            }
        }
    }
}

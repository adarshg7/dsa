class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;

        if (n <= 1) return true;

        Set<Integer>[] dp = new HashSet[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashSet<>();
        }

        if (stones[1] != 1) return false;

        if (n == 2) return true;

        dp[0].add(0);
        dp[1].add(1);

        for (int i = 1; i < n; i++) {

            for (int jump : dp[i]) {

                for (int nj = jump - 1; nj <= jump + 1; nj++) {

                    if (nj <= 0) continue;

                    int np = stones[i] + nj;

                    for (int j = i + 1; j < n; j++) {

                        if (stones[j] == np) {

                            dp[j].add(nj);

                            if (j == n - 1) {
                                return true;
                            }

                            break;
                        }

                        if (stones[j] > np) {
                            break;
                        }
                    }
                }
            }
        }

        return false;
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp,amount + 1);

        dp[0] = 0;

        for(int i = 1; i<= amount; i++){
            for(int coin : coins){
                 if(i - coin >= 0)
                dp[i] = Math.min(dp[i], 1+ dp[i - coin]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}

//OR

class Solution {
    public int coinChange(int[] coins, int amount) {
        int memo[] = new int[amount + 1];
        Arrays.fill(memo,-1);
        return solve(coins,amount,memo);
    }

    public int solve(int coins[], int rem, int memo[]){
        if(rem < 0) return -1;

        if(rem == 0){
            return 0;
        }

        if(memo[rem] != -1) return memo[rem];

        int minCount = Integer.MAX_VALUE;

        for(int coin : coins){
            int res = solve(coins, rem - coin, memo);
            if(res >= 0 && res < minCount){
                minCount = 1 + res;
            }
        }

        memo[rem] = (minCount == Integer.MAX_VALUE) ? -1 : minCount;
        return memo[rem];
    }
}

//OR

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 0) return -1;
        if(amount == 0) return 0;

        int minCount = Integer.MAX_VALUE;

        for(int coin : coins){
            int res = coinChange(coins, amount - coin);
            if(res >= 0 && res < minCount){
                minCount = 1 + res;
            }
        }

        return (minCount == Integer.MAX_VALUE) ? -1 : minCount;
    }
}

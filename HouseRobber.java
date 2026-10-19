class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return f(0, nums, 0, dp);
    }

    public int f(int i, int[] nums, int sum, int[] dp) {
        if (i >= nums.length) {
            return sum;
        }

        if (dp[i] != -1) {
            return sum + dp[i];
        }

        int pick = f(i + 2, nums, 0, dp) + nums[i];
        int np = f(i + 1, nums, 0, dp);

        dp[i] = Math.max(pick, np);

        return sum + dp[i];
    }
}

//or

class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = 0;

        for(int i =0; i < nums.length; i++){
            int pick = nums[i] + prev2;

            int np = prev1;

            int curr = Math.max(pick,np);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

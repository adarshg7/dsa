class Solution {
    public int minSideJumps(int[] obstacles) {
        int INF = 1000000;

        int dp[] = {1,0,1};

        for(int i = 1; i < obstacles.length; i++ ){
            int obstacle = obstacles[i];

            if(obstacle != 0){
                dp[obstacle - 1] = INF;
            }

            int min = Math.min(dp[0],Math.min(dp[1],dp[2]));

            for(int lane = 0; lane < 3; lane++){
                if(lane + 1 != obstacle){
                    dp[lane] = Math.min(dp[lane], min + 1);
                }
            }
        }

        return Math.min(dp[0], Math.min(dp[1],dp[2]));
    }
}

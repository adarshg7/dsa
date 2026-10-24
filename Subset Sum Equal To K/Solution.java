import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean dp[][] = new boolean[n][k+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }

        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for(int i = 1; i<n ; i++){
            for(int j = 1; j <= k; j++){
                boolean nt = dp[i-1][j];
                boolean take = false;
                if(arr[i] <= j){
                    take = dp[i - 1][j - arr[i]];
                }

                dp[i][j] = nt || take;
            }
        }

        return dp[n - 1][k];
    }
}

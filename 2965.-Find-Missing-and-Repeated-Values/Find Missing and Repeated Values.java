class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
    int arr[] = new int[n*n +1];
    int res[] = new int[2];
    int sum = 0;

    for(int i =0; i<n; i++){
        for(int j =0; j<n; j++){
            int a = grid[i][j];
            arr[a]++;
            if(arr[a]==2){
                res[0] = a;
            }
            sum+= a;
        }
    }
    int b = ((n*n)*((n*n)+1))/2;
    res[1] = b - (sum - res[0]);
    return res;
    }
}

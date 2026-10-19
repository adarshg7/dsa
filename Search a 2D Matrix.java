class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int idx = 0;
        for(int i =0; i<n; i++){
            if(matrix[i][m-1] == target){
                return true;
            }else if(matrix[i][m-1] > target){
                idx = i;
                break;
            }
        }
        
        for(int i =0; i<m -1; i++){
            if(matrix[idx][i] == target){
                return true;
            }
        }
        return false;
    }
}

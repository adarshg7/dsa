class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length , l = 0, h = m - 1;
        while(l <= h){
            int mid = l + (h - l)/2;
            int maxRow = 0;
            for(int i = 1; i< n; i++){
                if(mat[maxRow][mid] < mat[i][mid] ){
                    maxRow = i;
                }
            }

            int left = mid > 0 ? mat[maxRow][mid - 1]:-1;
            int right = mid < m - 1 ? mat[maxRow][mid + 1]:-1;

            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right) {
                return new int[]{maxRow, mid};
            }

            if(left> mat[maxRow][mid]){
                h = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
}

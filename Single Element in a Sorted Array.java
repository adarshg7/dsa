class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        if( n == 1) return arr[0];
        if(arr[0] != arr[1]) return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-1];
        int l = 1;
        int r = arr.length - 2;
        while( l <= r){
            int mid = l + (r-l)/2;

            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }

            if(mid % 2 == 1 && arr[mid] == arr[mid -1] || mid % 2 == 0 && arr[mid] == arr[mid + 1]){
                l = mid + 1;
            }else{
                r = mid -1;
            }
        }

        return -1;
    }
}

public class Solution {
    public static int[] MinToMaxHeap(int n, int[] arr){
        for(int i = n/2 - 1; i >= 0; i--){
            heapify(n,arr,i);
        }
        return arr;
    }

    public static void heapify(int n , int arr[], int i){
        while(true){
            int largest = i;

            int left = 2* i + 1;
            int right = 2*i + 2;

            if(left < n && arr[left] > arr[largest]){
                largest = left;
            }

            if(right < n && arr[right] > arr[largest]){
                largest = right;
            }

            if(largest == i){
                break;
            }

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            i = largest;
        }
    }
}

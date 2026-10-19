class Solution {
    public int findKthLargest(int[] nums, int k) {

        int[] heap = new int[k];
        int size = 0;
        for (int num : nums) {

            if (size < k) {
                heap[size] = num;
                size++;
                int i = size - 1;

                while (i > 0) {
                    int parent = (i - 1) / 2;

                    if (heap[parent] <= heap[i]) {
                        break;
                    }

                    int temp = heap[parent];
                    heap[parent] = heap[i];
                    heap[i] = temp;

                    i = parent;
                }

            } else {
                if (num > heap[0]) {

                    heap[0] = num;
                    heapify(heap, k, 0);
                }
            }
        }

        return heap[0];
    }

    public void heapify(int[] arr, int n, int i) {

        int smallest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != i) {

            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            heapify(arr, n, smallest);
        }
    }
}

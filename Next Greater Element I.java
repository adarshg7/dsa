class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int num : nums2){
            while(!st.isEmpty() && st.peek() < num){
                map.put(st.pop(),num);
            }
            st.push(num);
        }

        int arr[] = new int[nums1.length];
        for(int i =0; i< nums1.length; i++){
            arr[i] = map.getOrDefault(nums1[i],-1);
        }
        return arr;
    }
}

//or

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] a = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int j = 0;

            while (j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    int k = j + 1;
                    while (k < nums2.length && nums2[k] <= nums1[i]) {
                        k++;
                    }
                    a[i] = (k < nums2.length) ? nums2[k] : -1;
                    break;
                }
                j++;
            }
        }
        return a;
    }
}

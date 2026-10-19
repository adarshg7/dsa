class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int a = 0;
        int b = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[seq.length()];
        for (char c : seq.toCharArray()) {
            if (c == '(') {
                if (a == b) {
                    sb.append('a');   
                    a++;
                    arr[i++] = 0;
                } else {
                    sb.append('b');   
                    b++;
                    arr[i++] = 1;
                }
            } else {
                if (sb.charAt(sb.length() - 1) == 'a') {
                    a--;
                    arr[i++] = 0;
                    sb.setLength(sb.length() - 1);
                } else {
                    b--;
                    arr[i++] = 1;
                    sb.setLength(sb.length() - 1);
                }
            }
        }

        return arr;
    }
}


//or


class Solution {
    public int[] maxDepthAfterSplit(String seq) {

        int[] arr = new int[seq.length()];
        int depth = 0;

        for (int i = 0; i < seq.length(); i++) {

            if (seq.charAt(i) == '(') {
                depth++;
                arr[i] = depth % 2;
            } else {
                arr[i] = depth % 2;
                depth--;
            }
        }

        return arr;
    }
}

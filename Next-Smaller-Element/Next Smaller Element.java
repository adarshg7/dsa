import java.util.*;
import java.io.*;

public class Solution {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr.get(st.peek()) > arr.get(i)) {
                result.set(st.pop(), arr.get(i));
            }
            st.push(i);
        }

        return result;
    }
}

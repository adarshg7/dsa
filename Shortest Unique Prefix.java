import java.util.*;
import java.io.*;

public class Solution {

    static class Node {
        Node[] arr = new Node[26];
        boolean eow;
        int freq = 1;
    }

    public static String[] shortestUniquePrefix(String[] s, int n) {

        Node root = new Node();
        for(String str : s) {
            Node curr = root;
            for(char c : str.toCharArray()) {
                int idx = c - 'a';
                if(curr.arr[idx] == null) {
                    curr.arr[idx] = new Node();
                } else {
                    curr.arr[idx].freq++;
                }
                curr = curr.arr[idx];
            }

            curr.eow = true;
        }
        String[] ans = new String[n];

        for(int i = 0; i < n; i++) {
            String str = s[i];
            StringBuilder sb = new StringBuilder();
            Node curr = root;
            for(char c : str.toCharArray()) {
                int idx = c - 'a';
                curr = curr.arr[idx];
                sb.append(c);
                if(curr.freq == 1) {
                    break;
                }
            }

            ans[i] = sb.toString();
        }

        return ans;
    }
}

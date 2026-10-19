import java.util.*;

class Solution {

    private int timer = 1;

    private void dfs(
            int node,
            int parent,
            ArrayList<ArrayList<Integer>> adj,
            int[] vis,
            int[] tin,
            int[] low,
            int[] mark) {

        vis[node] = 1;

        tin[node] = low[node] = timer;
        timer++;

        int child = 0;

        for (int it : adj.get(node)) {
            if (it == parent) {
                continue;
            }
            if (vis[it] == 0) {

                dfs(it, node, adj, vis, tin, low, mark);

                low[node] = Math.min(low[node], low[it]);
                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }

                child++;
            }

            else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        if (parent == -1 && child > 1) {
            mark[node] = 1;
        }
    }

    public ArrayList<Integer> articulationPoints(int V, int[][] edges) {

        timer = 1;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];

        for (int i = 0; i < V; i++) {

            if (vis[i] == 0) {
                dfs(i, -1, adj, vis, tin, low, mark);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {

            if (mark[i] == 1) {
                ans.add(i);
            }
        }

        if (ans.size() == 0) {
            ans.add(-1);
        }

        return ans;
    }
}

import java.util.*;

class Solution {

    int timer = 1;

    private void dfs(
            int node,
            int parent,
            ArrayList<ArrayList<Integer>> adj,
            int[] vis,
            int[] tin,
            int[] low,
            ArrayList<ArrayList<Integer>> bridges) {

        vis[node] = 1;

        tin[node] = low[node] = timer;
        timer++;

        for (int it : adj.get(node)) {

            // Don't go back to parent
            if (it == parent) {
                continue;
            }

            // If node is not visited
            if (vis[it] == 0) {

                dfs(it, node, adj, vis, tin, low, bridges);

                low[node] = Math.min(low[node], low[it]);

                // Bridge condition
                if (low[it] > tin[node]) {
                    ArrayList<Integer> bridge = new ArrayList<>();

                    bridge.add(node);
                    bridge.add(it);

                    bridges.add(bridge);
                }
            }

            else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(
            int n,
            List<List<Integer>> connections) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> it : connections) {
            adj.get(it.get(0)).add(it.get(1));
            adj.get(it.get(1)).add(it.get(0));
        }

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        ArrayList<ArrayList<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, adj, vis, tin, low, bridges);

        return new ArrayList<>(bridges);
    }
}

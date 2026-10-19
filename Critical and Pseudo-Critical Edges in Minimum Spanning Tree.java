class Solution {

    class DSU{
        int[] parent;
        int rank[];

        DSU(int n ){
            parent = new int[n];
            rank = new int[n];

            for(int i =0; i<n; i++){
                parent[i] = i;
            }
        }

        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb){
                return false;
            }

            if(rank[pa] < rank[pb]){
                parent[pa] = pb;
            }else if(rank[pa] > rank[pb]){
                parent[pb] = pa;
            }else{
                parent[pb] = pa;
                rank[pa]++;
            }

            return true;
        }
    }

    public int kruskal(int n , int edges[][], int skip, int force){
        DSU dsu = new DSU(n);

        int weight = 0;
        int count = 0;

        if(force != -1){
            int u = edges[force][0];
            int v = edges[force][1];
            int w = edges[force][2];

            if(dsu.union(u,v)){
                weight += w;
                count++;
            }
        }

            for(int i =0; i<edges.length; i++){
                if( i == skip || i == force){
                    continue;
                }

                int u = edges[i][0];
                int v = edges[i][1];
                int w = edges[i][2];

                if(dsu.union(u,v)){
                    weight += w;
                    count++;

                    if(count == n - 1){
                        break;
                    }
                }
            }

            if(count != n-1){
                return Integer.MAX_VALUE;
            }
        return weight;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int newEdges[][] = new int[edges.length][4];

        for(int i =0; i< edges.length; i++){
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, (a,b) -> a[2] - b[2]);

        int base = kruskal(n, newEdges, -1 ,-1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for(int i =0; i<newEdges.length; i++){
            int withoutEdges = kruskal(n,newEdges, i , -1);

            if(withoutEdges > base){
                critical.add(newEdges[i][3]);
            }else{
                int withEdge = kruskal(n,newEdges, -1, i);

                if(withEdge == base){
                    pseudo.add(newEdges[i][3]);
                }
            }
        }

        List<List<Integer>> answer = new ArrayList<>();

        answer.add(critical);
        answer.add(pseudo);

        return answer;

    }
}

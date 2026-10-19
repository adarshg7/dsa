class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i =0; i< numCourses; i++){
            list.add(new ArrayList<>());
        }

        for(int pre[] : prerequisites){
            list.get(pre[1]).add(pre[0]);
        }

        int path[] = new int[numCourses];

        int vis[] = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(vis[i] == 0){
                if(dfs(i,vis,path,list) ==  true){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node, int vis[], int path[], ArrayList<ArrayList<Integer>> list){
        vis[node] = 1;
        path[node] = 1;

        for(int i : list.get(node)){
            if(vis[i] == 0){
                if(dfs(i,vis,path,list) == true){
                    return true;
                }
            }else if(path[i] == 1){
                return true;
            }
        }

        path[node] = 0;
        return false;
    }
}

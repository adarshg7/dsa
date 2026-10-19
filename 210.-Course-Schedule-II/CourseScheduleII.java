import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for(int pre[] : prerequisites){
            list.get(pre[1]).add(pre[0]);
        }

        int vis[] = new int[numCourses];
        int path[] = new int[numCourses];
        int arr[] = new int[numCourses];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < numCourses; i++){
            if(vis[i] == 0) {
                if(dfs(i, vis, path, list, st) == true){
                    return new int[0]; 
                }
            }
        }
        int j = 0;
        while(!st.isEmpty()) {
            arr[j++] = st.pop();
        }

        return arr;
    }


    public boolean dfs(int node,int vis[], int path[], ArrayList<ArrayList<Integer>> list, Stack<Integer> st){
        vis[node] = 1;
        path[node] = 1;
        for(int i : list.get(node)){
            if(vis[i] == 0){
                if(dfs(i, vis, path, list, st) == true){
                    return true;
                }
            }
            else if(path[i] == 1){
                return true;    
            }
        }
        path[node] = 0;
        st.push(node);

        return false;
    }
}

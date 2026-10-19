/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    
     TreeNode(int val) {
         this.val = val;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;

class Pair{
    TreeNode node;
    int v;
    Pair(TreeNode node, int v){
        this.node = node;
        this.v = v;
    }
}

public class Solution {
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root,0));       

        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode n = p.node;
            int va = p.v;

            map.put(va,n.val);

            if(n.left != null) q.add(new Pair(n.left,va-1));
            if(n.right != null) q.add(new Pair(n.right,va+1));
        } 

        list = new ArrayList(map.values());
        return list;
    }
}

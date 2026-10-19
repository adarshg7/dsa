/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair {
    TreeNode node;
    long v;

    Pair(TreeNode node, long v) {
        this.node = node;
        this.v = v;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            long first = q.peek().v;
            long last = first;

            for(int i =0; i< size; i++){
                Pair p = q.poll();
                TreeNode n = p.node;
                long index = p.v;

                last = index;

                if(n.left != null){
                    q.offer(new Pair(n.left,2*index));
                }
                if(n.right != null){
                    q.offer(new Pair(n.right, 2*index + 1));
                }
            }

            ans = Math.max(ans,(int)(last-first+1));
        }
        return ans;
    }
}

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
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if( root == null ) return list;
        if(root.left != null) helper(root.left);
        list.add(root.val);
        if(root.right != null) helper(root.right);
        return list;
    }

    public void helper(TreeNode root){
        if( root == null ) return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }

}

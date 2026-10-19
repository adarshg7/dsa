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
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return list;

        if(root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
            return list;
        }

        StringBuilder sb = new StringBuilder(); 
        sb.append(root.val);
        if(root.left != null) path(root.left,sb);
        if(root.right != null) path(root.right,sb);
        return list;
    }

    public void path(TreeNode root, StringBuilder sb){
        int size = sb.length();
        sb.append("->").append(root.val);

        if(root.left == null && root.right == null){
            list.add(sb.toString());
        }
        else{
            if (root.left != null) path(root.left, sb);
            if (root.right != null) path(root.right, sb);
        }
        sb.setLength(size);
    }
}

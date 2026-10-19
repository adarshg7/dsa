class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
       maxPathSu(root);
       return max;
    }

    public int maxPathSu(TreeNode root){
         if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPathSu(root.left));
        int right = Math.max(0, maxPathSu(root.right));

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}

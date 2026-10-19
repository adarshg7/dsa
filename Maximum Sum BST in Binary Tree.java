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
    int ans = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans ;
    }

    public int[] dfs(TreeNode root){
        if(root == null) return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};

        int left[] = dfs(root.left);
        int right[] = dfs(root.right);

        if(root.val > left[1] && root.val < right[0]){
            int sum = left[2] + root.val + right[2];
            ans = Math.max(ans,sum);

            int min = Math.min(root.val,left[0]);
            int max = Math.max(root.val,right[1]);

            return new int[]{min,max,sum};
        }

        return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,0};
    }


}

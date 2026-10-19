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
    HashSet<Integer> set = new HashSet<>();
    boolean flag = false;
    public boolean findTarget(TreeNode root, int k) {
       if(root == null) return false;
       f(root,k);
       return flag;
    }

    public void f(TreeNode root, int k){
        if(root == null ) return;
        
        if(set.contains(k - root.val)) {
            flag = true;
            return;
        }
        if(!set.contains(root.val)){
            set.add(root.val);
        }


        f(root.left,k);
        f(root.right,k);
    }
}


//or


class Solution {
    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}

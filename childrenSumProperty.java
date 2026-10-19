import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        if(root == null) return;
        int sum = 0;
        if(root.left != null) sum += root.left.data;
        if(root.right != null) sum += root.right.data;

        if(sum > root.data) root.data = sum;
        else {
            if(root.left != null) root.left.data = root.data;
            else if(root.right != null) root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int tots = 0;
        if(root.left != null) tots += root.left.data;
        if(root.right != null) tots += root.right.data;

        if(root.left != null || root.right != null) root.data = tots;
    }
}

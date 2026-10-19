/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        map.put(root,null);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                if(!map.containsKey(node.left)){
                    map.put(node.left,node);
                    q.offer(node.left);
                }
            }

            if(node.right != null){
                if(!map.containsKey(node.right)){
                    map.put(node.right,node);
                    q.offer(node.right);
                }
            }
        }

        Map<TreeNode,Boolean> vis = new HashMap<>();

        Queue<TreeNode> q2 = new LinkedList<>();

        q2.offer(target);

        vis.put(target,true);
        int currLevel = 0;
        while(!q2.isEmpty()){
            int size = q2.size();

            if(currLevel == k) break;

            currLevel++;

            for(int i =0; i<size; i++){
                TreeNode curr = q2.poll();

                if(curr.left != null && vis.get(curr.left) == null){
                    q2.offer(curr.left);
                    vis.put(curr.left,true);
                }

                if(curr.right != null && vis.get(curr.right) == null){
                    q2.offer(curr.right);
                    vis.put(curr.right,true);
                }

                if(map.get(curr) != null && vis.get(map.get(curr)) == null){
                    q2.offer(map.get(curr));
                    vis.put(map.get(curr),true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!q2.isEmpty()){
            TreeNode current = q2.poll();
            result.add(current.val);
        }
        return result;

    }
}

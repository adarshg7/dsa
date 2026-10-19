class Solution {

    public int amountOfTime(TreeNode root, int start) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        parent.put(root, null);

        TreeNode startNode = null;

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node.val == start) {
                startNode = node;
            }

            if (node.left != null) {
                parent.put(node.left, node);
                q.offer(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                q.offer(node.right);
            }
        }
        Queue<TreeNode> q2 = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q2.offer(startNode);
        visited.add(startNode);

        int time = 0;

        while (!q2.isEmpty()) {

            int size = q2.size();
            boolean infected = false;

            for (int i = 0; i < size; i++) {

                TreeNode node = q2.poll();

                if (node.left != null && visited.add(node.left)) {
                    q2.offer(node.left);
                    infected = true;
                }

                if (node.right != null && visited.add(node.right)) {
                    q2.offer(node.right);
                    infected = true;
                }

                TreeNode p = parent.get(node);

                if (p != null && visited.add(p)) {
                    q2.offer(p);
                    infected = true;
                }
            }

            if (infected) {
                time++;
            }
        }

        return time;
    }
}

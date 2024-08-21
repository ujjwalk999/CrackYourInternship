class Solution {
    private Map<TreeNode, TreeNode> parentPointers = new HashMap<>();
    private List<Integer> atDistanceK = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        populateParentPointers(root);
        performBFS(target, k);
        return atDistanceK;
    }

    private void performBFS(TreeNode target, int k){
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(new Pair(target, 0));

        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.remove();
            TreeNode node  = pair.getKey();
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            int distance = pair.getValue();
            if (distance == k) {
                atDistanceK.add(node.val);
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, distance + 1));
            }
            if (node.left != null) {
                queue.offer(new Pair(node.left, distance + 1));
            }
            if (parentPointers.get(node) != null) {
                queue.offer(new Pair(parentPointers.get(node), distance + 1));
            }
        }
    }

    private void populateParentPointers(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentPointers.put(root.left, root);
        }
        if (root.right != null) {
            parentPointers.put(root.right, root);
        }
        populateParentPointers(root.left);
        populateParentPointers(root.right);
    }
}

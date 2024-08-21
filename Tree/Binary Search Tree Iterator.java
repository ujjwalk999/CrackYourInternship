class BSTIterator {
        Queue<Integer> list;
        public BSTIterator(TreeNode root) {
            list = new LinkedList<>();
            traverseBST(root, list);
        }

        public int next() {
            return list.poll();
        }

        public boolean hasNext() {
            return !list.isEmpty();
        }
        
        private void traverseBST(TreeNode node, Queue<Integer> list) {
            if (node == null) return;
            
            traverseBST(node.left, list);
            list.add(node.val);
            traverseBST(node.right, list);
        }
}

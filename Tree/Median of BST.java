class Tree {
    public static float findMedian(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        int n = list.size();
        if (n % 2 == 0) {
            return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0f;
        } else {
            return list.get(n / 2);
        }
    }

    private static void inorderTraversal(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, list);
        list.add(node.data);
        inorderTraversal(node.right, list);
    }
}

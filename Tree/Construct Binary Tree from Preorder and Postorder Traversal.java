class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        if (preStart == preEnd) return root;

        int leftRootVal = preorder[preStart + 1];
        int leftRootIndex = postStart;
        while (postorder[leftRootIndex] != leftRootVal) leftRootIndex++;

        int leftSize = leftRootIndex - postStart + 1;

        root.left = build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, leftRootIndex);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, leftRootIndex + 1, postEnd - 1);

        return root;
    }
}

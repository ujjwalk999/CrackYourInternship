class Solution {
    int index = 0;

    Node constructTree(int n, int pre[], char preLN[]) {
        if (index == n) {
            return null;
        }

        Node node = new Node(pre[index]);

        if (preLN[index++] == 'L') {
            return node;
        }

        node.left = constructTree(n, pre, preLN);
        node.right = constructTree(n, pre, preLN);

        return node;
    }
}

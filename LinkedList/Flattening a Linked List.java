class Solution {
    // Function to merge two sorted linked lists
    Node merge(Node one, Node two) {
        if (one == null) return two;
        if (two == null) return one;

        Node temp;
        if (one.data < two.data) {
            temp = one;
            temp.bottom = merge(one.bottom, two);
        } else {
            temp = two;
            temp.bottom = merge(one, two.bottom);
        }
        return temp;
    }

    // Function to flatten a linked list
    public Node flatten(Node root) {
        if (root == null) return root;
        return merge(root, flatten(root.next));
    }
}

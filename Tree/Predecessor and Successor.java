class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        findPreSucUtil(root, pre, suc, key);
    }

    private static void findPreSucUtil(Node root, Node[] pre, Node[] suc, int key) {
        if (root == null) {
            return;
        }

        if (root.data == key) {
            // Find predecessor
            Node temp = root.left;
            while (temp != null) {
                if (temp.right == null) {
                    pre[0] = temp;
                    break;
                }
                temp = temp.right;
            }

            // Find successor
            temp = root.right;
            while (temp != null) {
                if (temp.left == null) {
                    suc[0] = temp;
                    break;
                }
                temp = temp.left;
            }
            return;
        }

        if (root.data > key) {
            suc[0] = root;
            findPreSucUtil(root.left, pre, suc, key);
        } else {
            pre[0] = root;
            findPreSucUtil(root.right, pre, suc, key);
        }
    }
}

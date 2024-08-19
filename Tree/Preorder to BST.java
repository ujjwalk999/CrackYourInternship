static class Solution {
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        // code here
        Node root = new Node(pre[0]);
        for(int i =1; i<size; i++){
            dfs(pre[i],root);
        }
        return root;
    }
    static Node dfs(int key , Node head){
        if(head == null){
            Node node = new Node(key);
            return node;
        }
        if(key < head.data){
           head.left = dfs(key , head.left);
        }
        else{
           head.right = dfs(key , head.right);
        }
        return head;
}
}

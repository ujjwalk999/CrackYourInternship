class NodeValue {
    
    public int minNode, maxNode, size;
    
    NodeValue(int minNode, int maxNode, int size) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.size = size;
    }
}

class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        // new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        
        return findLargeSubTree(root).size;
    
        
    }
    
    static NodeValue findLargeSubTree(Node root) {
        
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        NodeValue left = findLargeSubTree(root.left);
        NodeValue right = findLargeSubTree(root.right);
        
        if (left.maxNode < root.data && root.data < right.minNode) {
            
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode),
            left.size + right.size + 1);
        }
        
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
        
    }
    
    
    
}

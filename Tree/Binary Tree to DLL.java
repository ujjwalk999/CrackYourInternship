class Solution
{
    Node head = null;
    Node temp =  null;
    
    void helper(Node root){
        if(root == null){
            return;
        }
        helper(root.left);
        if(temp == null){
            head = root ;
        }
        else{
            temp.right = root;
            root.left = temp;
        }
        temp = root;
        helper(root.right);
    }
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	//  Your code here	
	if(root == null){
	    return root;
	}
	helper(root);
	return head;
    }
}

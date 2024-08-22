class Solution
{
    int count;
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        count = 0;
        process(root,l,h);
        return count;
    
}
private void process(Node root, int l, int h){
    if(root ==  null)return;
            if(root.data >= l && root.data <= h){
                count++;
            }
        
         process(root.left,l,h);
            process(root.right,l,h);
    }
}

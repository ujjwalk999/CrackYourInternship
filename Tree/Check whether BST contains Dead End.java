class Solution
{
    
   static boolean dead(Node root,int min, int max){
        if(root == null){
          return  false;
        }
        if(min == max){
            return true;
        }
        return dead( root.left, min, root.data -1) ||  dead( root.right, root.data +1 , max);
    }
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        return dead(root,1,10001);
    }
}

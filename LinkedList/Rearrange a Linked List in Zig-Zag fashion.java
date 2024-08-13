class Solution {
    Node zigZag(Node head) {
        // add code here.
        
        Node node = head;
        int flag = 0;
        while(node.next != null){
            if(flag == 0){
               if( node.data > node.next.data){
                   int temp = node.data;
                   node.data = node.next.data;
                   node.next.data = temp;
               }
               flag = 1;
            }
            else{
                if( node.data < node.next.data){
                   int temp = node.data;
                   node.data = node.next.data;
                   node.next.data = temp;
               }
               flag = 0;
            }
            node = node.next;
        }
        return head;
    }
}

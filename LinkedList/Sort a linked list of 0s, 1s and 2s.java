class Solution {
    
   public Node sort(Node head){
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        Node current = head;
        while(current != null){
            pq.add(current);
            current = current.next;
        }
        Node dummy = new Node(-1);
        current = dummy;
        
        while(!pq.isEmpty()){
            current.next = pq.poll();
            current = current.next;
        }
        current.next = null;
        
        return dummy.next;
   }


}

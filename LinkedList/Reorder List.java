class Solution {
    public void reorderList(ListNode head) {
       
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast !=null && fast.next !=null ){
            slow = slow.next;
            fast = fast.next.next;
        } 

        ListNode pre = null;
        ListNode curr = slow;
        ListNode nextnode = null;
        while(curr !=null){
         nextnode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextnode;
        }
          
          ListNode first = head;
          ListNode second = pre;
          ListNode temp = head;

          while(second.next !=null){
            temp = temp.next;
            first.next = second;
            second = second.next;
            first.next.next = temp;
            first = first.next.next;
          }

    }
}

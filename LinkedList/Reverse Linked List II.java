class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftpre = dummy;
        ListNode current = head;
        for(int i =0; i< left-1; i++){
            leftpre = leftpre.next;
            current = current.next;
        }
        ListNode subListHead = current;

         ListNode prenode = null;
        for( int i =0; i<= right - left; i++){
                ListNode nextnode = current.next;
                current.next = prenode;
                prenode = current;
                current = nextnode;
        }
        leftpre.next = prenode;
        subListHead.next = current;

        return dummy.next;
    }
}

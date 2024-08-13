class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode beforecurr = before;
        ListNode aftercurr = after;

        while(head != null){
            if(head.val < x){
                beforecurr.next = head;
                beforecurr = beforecurr.next;
            }
            else{
                aftercurr.next = head;
                aftercurr = aftercurr.next;
            }
            head = head.next;
        }
        aftercurr.next = null;
        beforecurr.next = after.next;

        return before.next;
    }
}

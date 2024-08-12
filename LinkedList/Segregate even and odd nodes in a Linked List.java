class Solution {
    Node divide(Node head) {
        Node even = new Node(0);
        Node odd = new Node(0);
        Node evenPtr = even;
        Node oddPtr = odd;
        
        while (head != null) {
            if (head.data % 2 == 0) {
                evenPtr.next = head;
                evenPtr = evenPtr.next;
            } else {
                oddPtr.next = head;
                oddPtr = oddPtr.next;
            }
            head = head.next;
        }
        
        evenPtr.next = odd.next;
        oddPtr.next = null;
        
        return even.next;
    }
}

class Solution {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode result = new ListNode();
		ListNode current = result;

		while (!Objects.isNull(list1) || !Objects.isNull(list2)) {
			if (!Objects.isNull(list2) && (Objects.isNull(list1) || list1.val > list2.val)) {
				current.next = new ListNode(list2.val);
				list2 = list2.next;
			} else {
				current.next = new ListNode(list1.val);
				list1 = list1.next;
			}
			current = current.next;
		}
		return result.next;
	}
}

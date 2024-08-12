class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        long num1 = 0;
        long num2 = 0;
        long mod = 1000000007;

        Node p1 = first;
        Node p2 = second;

        while (p1 != null) {
            num1 = (num1 * 10)%mod + p1.data;
            p1 = p1.next;
        }

        while (p2 != null) {
            num2 = (num2 * 10)%mod  + p2.data;
            p2 = p2.next;
        }

        return (num1 * num2) % mod;
    }
}

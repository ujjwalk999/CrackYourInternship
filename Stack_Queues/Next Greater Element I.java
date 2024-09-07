
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Create a hashmap to store the next greater element for each number in nums2
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        // Use a stack to keep track of the elements for which we are looking for the next greater element
        Stack<Integer> stack = new Stack<>();

        // Traverse through nums2 and populate the nextGreaterMap
        for (int num : nums2) {
            // While the stack is not empty and the current number is greater than the stack's top element
            while (!stack.isEmpty() && num > stack.peek()) {
                // The current number is the next greater element for the stack's top
                nextGreaterMap.put(stack.pop(), num);
            }
            // Push the current number onto the stack
            stack.push(num);
        }

        // The elements left in the stack do not have a next greater element in nums2
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }

        // Array to store the result
        int[] result = new int[nums1.length];
        // For each number in nums1, find its next greater element using the map
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        // Return the populated result array
        return result;
    }
}

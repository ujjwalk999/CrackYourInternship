// Function to push element x to the back of the deque.
public static void push_back_pb(ArrayDeque<Integer> dq, int x) {
    dq.addLast(x); // or dq.offerLast(x)
}

// Function to pop element from back of the deque.
public static void pop_back_ppb(ArrayDeque<Integer> dq) {
    if (!dq.isEmpty()) {
        dq.removeLast(); // or dq.pollLast()
    }
}

// Function to return element from front of the deque.
public static int front_dq(ArrayDeque<Integer> dq) {
    if (!dq.isEmpty()) {
        return dq.peekFirst(); // or dq.getFirst()
    } else {
        return -1;
    }
}

// Function to push element x to the front of the deque.
public static void push_front_pf(ArrayDeque<Integer> dq, int x) {
    dq.addFirst(x); // or dq.offerFirst(x)
}

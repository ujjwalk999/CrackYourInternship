class Solution {
    public static int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        HashMap<Integer, Node> map = new HashMap<>();

        for (int[] pair : adjacentPairs) {
            if (map.containsKey(pair[0]) && map.containsKey(pair[1])) {
                Node node0 = map.get(pair[0]);
                Node node1 = map.get(pair[1]);

                if (node0.left == null) node0.left = node1;
                else node0.right = node1;

                if (node1.left == null) node1.left = node0;
                else node1.right = node0;
            }
            else if (map.containsKey(pair[0])) {
                Node node0 = map.get(pair[0]);
                Node node1 = Node.of(pair[1]);

                if (node0.left == null) node0.left = node1;
                else node0.right = node1;

                node1.left = node0;

                map.put(pair[1], node1);
            }
            else if (map.containsKey(pair[1])) {
                Node node1 = map.get(pair[1]);
                Node node0 = Node.of(pair[0]);

                if (node1.left == null) node1.left = node0;
                else node1.right = node0;

                node0.left = node1;

                map.put(pair[0], node0);
            }
            else {
                Node node0 = Node.of(pair[0]);
                Node node1 = Node.of(pair[1]);

                node0.left = node1;
                node1.right = node0;

                map.put(pair[0], node0);
                map.put(pair[1], node1);
            }
        }

        int start = 0;
        for (Node node : map.values()) {
            if (node.left == null || node.right == null) {
                start = node.value;
                break;
            }
        }

        int[] answer = new int[n+1];
        answer[0] = start;

        Node node = map.get(start);
        if (node.left != null) node = node.left;
        else node = node.right;

        int index = 1;
        while (index <= n) {
            answer[index] = node.value;
            if (node.left != null && node.left.value != answer[index-1]) {
                node = node.left;
            }
            else {
                node = node.right;
            }
            index++;
        }

        return answer;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        static Node of(int value) {
            return new Node(value, null, null);
        }
    }
}

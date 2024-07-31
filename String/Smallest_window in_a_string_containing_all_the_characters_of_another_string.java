class Solution {
    public static String smallestWindow(String s, String p) {
        if (s == null || p == null) {
            return "-1";
        }

        int n = s.length();
        int m = p.length();
        if (m > n) {
            return "-1";
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        int count = 0;

        HashMap<Character, Integer> hpp = new HashMap<>();
        for (int i = 0; i < m; i++) {
            hpp.put(p.charAt(i), hpp.getOrDefault(p.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> windowCounts = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char rightChar = s.charAt(right);
            if (hpp.containsKey(rightChar)) {
                windowCounts.put(rightChar, windowCounts.getOrDefault(rightChar, 0) + 1);
                if (windowCounts.get(rightChar) <= hpp.get(rightChar)) {
                    count++;
                }
            }

            while (count == m) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                if (hpp.containsKey(leftChar)) {
                    windowCounts.put(leftChar, windowCounts.getOrDefault(leftChar, 0) - 1);
                    if (windowCounts.get(leftChar) < hpp.get(leftChar)) {
                        count--;
                    }
                }

                left++;
            }
        }

        return startIndex == -1? "-1" : s.substring(startIndex, startIndex + minLen);
    }
}

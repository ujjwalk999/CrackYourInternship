public class BoyerMoore {
    private static final int NO_OF_CHARS = 256;

    private static void badCharHeuristic(char[] pattern, int[] badchar) {
        for (int i = 0; i < NO_OF_CHARS; i++) {
            badchar[i] = -1;
        }
        for (int i = 0; i < pattern.length; i++) {
            badchar[pattern[i]] = i;
        }
    }

    public static void search(char[] text, char[] pattern) {
        int[] badchar = new int[NO_OF_CHARS];
        badCharHeuristic(pattern, badchar);
        int shift = 0;
        while (shift <= text.length - pattern.length) {
            int j = pattern.length - 1;
            while (j >= 0 && pattern[j] == text[shift + j]) {
                j--;
            }
            if (j < 0) {
                System.out.println("Pattern occurs at shift = " + shift);
                shift += (shift + pattern.length < text.length) ? pattern.length - badchar[text[shift + pattern.length]] : 1;
            } else {
                shift += Math.max(1, j - badchar[text[shift + j]]);
            }
        }
    }

    public static void main(String[] args) {
        char[] text = "ABAAABCD".toCharArray();
        char[] pattern = "ABC".toCharArray();
        search(text, pattern);
    }
}

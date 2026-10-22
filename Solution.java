
public class Solution {

    private static final int NOT_POSSIBLE = -1;
    private static final int[] RANGE_MIN_OPERATIONS = {0, 1, 2, 3};

    public int minOperations(String s) {
        char[] input = s.toCharArray();
        if (input.length == 2 && input[0] > input[1]) {
            return NOT_POSSIBLE;
        }

        if (isSorted(input)) {
            return RANGE_MIN_OPERATIONS[0];
        }

        if (minValueIsAtStart(input) || maxValueIsAtEnd(input)) {
            return RANGE_MIN_OPERATIONS[1];
        }

        if (noProperPrefixForMinValueExists(input) && noProperSuffixForMaxValueExists(input)) {
            return RANGE_MIN_OPERATIONS[3];
        }

        return RANGE_MIN_OPERATIONS[2];
    }

    private static boolean isSorted(char[] input) {
        for (int i = 1; i < input.length; ++i) {
            if (input[i - 1] > input[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean minValueIsAtStart(char[] input) {
        for (int i = 1; i < input.length; ++i) {
            if (input[0] > input[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean maxValueIsAtEnd(char[] input) {
        for (int i = 0; i < input.length - 1; ++i) {
            if (input[input.length - 1] < input[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean noProperPrefixForMinValueExists(char[] input) {
        for (int i = 1; i < input.length; ++i) {
            if (input[0] <= input[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean noProperSuffixForMaxValueExists(char[] input) {
        for (int i = input.length - 2; i >= 0; --i) {
            if (input[input.length - 1] >= input[i]) {
                return false;
            }
        }
        return true;
    }
}

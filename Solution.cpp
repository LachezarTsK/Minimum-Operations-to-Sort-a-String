
#include <array>
#include <string>
#include <string_view>
using namespace std;

class Solution {

    static const int NOT_POSSIBLE = -1;
    inline static array<int, 4> RANGE_MIN_OPERATIONS = { 0, 1, 2, 3 };

public:
    int minOperations(string input) {
        if (input.length() == 2 && input[0] > input[1]) {
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

private:
    static bool isSorted(string_view input) {
        for (int i = 1; i < input.length(); ++i) {
            if (input[i - 1] > input[i]) {
                return false;
            }
        }
        return true;
    }

    static bool minValueIsAtStart(string_view input) {
        for (int i = 1; i < input.length(); ++i) {
            if (input[0] > input[i]) {
                return false;
            }
        }
        return true;
    }

    static bool maxValueIsAtEnd(string_view input) {
        for (int i = 0; i < input.length() - 1; ++i) {
            if (input[input.length() - 1] < input[i]) {
                return false;
            }
        }
        return true;
    }

    static bool noProperPrefixForMinValueExists(string_view input) {
        for (int i = 1; i < input.length(); ++i) {
            if (input[0] <= input[i]) {
                return false;
            }
        }
        return true;
    }

    static bool noProperSuffixForMaxValueExists(string_view input) {
        for (int i = input.length() - 2; i >= 0; --i) {
            if (input[input.length() - 1] >= input[i]) {
                return false;
            }
        }
        return true;
    }
};

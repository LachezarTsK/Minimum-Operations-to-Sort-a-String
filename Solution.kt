
class Solution {

    private companion object {
        const val NOT_POSSIBLE = -1
        val RANGE_MIN_OPERATIONS = intArrayOf(0, 1, 2, 3)
    }

    fun minOperations(input: String): Int {
        if (input.length == 2 && input[0] > input[1]) {
            return NOT_POSSIBLE
        }

        if (isSorted(input)) {
            return RANGE_MIN_OPERATIONS[0]
        }

        if (minValueIsAtStart(input) || maxValueIsAtEnd(input)) {
            return RANGE_MIN_OPERATIONS[1]
        }

        if (noProperPrefixForMinValueExists(input) && noProperSuffixForMaxValueExists(input)) {
            return RANGE_MIN_OPERATIONS[3]
        }

        return RANGE_MIN_OPERATIONS[2]
    }

    private fun isSorted(input: String): Boolean {
        for (i in 1..<input.length) {
            if (input[i - 1] > input[i]) {
                return false
            }
        }
        return true
    }

    private fun minValueIsAtStart(input: String): Boolean {
        for (i in 1..<input.length) {
            if (input[0] > input[i]) {
                return false
            }
        }
        return true
    }

    private fun maxValueIsAtEnd(input: String): Boolean {
        for (i in 0..<input.length - 1) {
            if (input[input.length - 1] < input[i]) {
                return false
            }
        }
        return true
    }

    private fun noProperPrefixForMinValueExists(input: String): Boolean {
        for (i in 1..<input.length) {
            if (input[0] <= input[i]) {
                return false
            }
        }
        return true
    }

    private fun noProperSuffixForMaxValueExists(input: String): Boolean {
        for (i in input.length - 2 downTo (0)) {
            if (input[input.length - 1] >= input[i]) {
                return false
            }
        }
        return true
    }
}

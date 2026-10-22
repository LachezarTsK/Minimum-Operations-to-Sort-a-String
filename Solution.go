
package main

const NOT_POSSIBLE = -1
var RANGE_MIN_OPERATIONS = []int{0, 1, 2, 3}

func minOperations(input string) int {
    if len(input) == 2 && input[0] > input[1] {
        return NOT_POSSIBLE
    }

    if isSorted(input) {
        return RANGE_MIN_OPERATIONS[0]
    }

    if minValueIsAtStart(input) || maxValueIsAtEnd(input) {
        return RANGE_MIN_OPERATIONS[1]
    }

    if noProperPrefixForMinValueExists(input) && noProperSuffixForMaxValueExists(input) {
        return RANGE_MIN_OPERATIONS[3]
    }

    return RANGE_MIN_OPERATIONS[2]
}

func isSorted(input string) bool {
    for i := 1; i < len(input); i++ {
        if input[i - 1] > input[i] {
            return false
        }
    }
    return true
}

func minValueIsAtStart(input string) bool {
    for i := 1; i < len(input); i++ {
        if input[0] > input[i] {
            return false
        }
    }
    return true
}

func maxValueIsAtEnd(input string) bool {
    for i := 0; i < len(input) - 1; i++ {
        if input[len(input) - 1] < input[i] {
            return false
        }
    }
    return true
}

func noProperPrefixForMinValueExists(input string) bool {
    for i := 1; i < len(input); i++ {
        if input[0] <= input[i] {
            return false
        }
    }
    return true
}

func noProperSuffixForMaxValueExists(input string) bool {
    for i := len(input) - 2; i >= 0; i-- {
        if input[len(input) - 1] >= input[i] {
            return false
        }
    }
    return true
}

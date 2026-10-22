
/**
 * @param {string} input
 * @return {number}
 */
var minOperations = function (input) {
    if (input.length === 2 && input[0] > input[1]) {
        return Util.NOT_POSSIBLE;
    }

    if (isSorted(input)) {
        return Util.RANGE_MIN_OPERATIONS[0];
    }

    if (minValueIsAtStart(input) || maxValueIsAtEnd(input)) {
        return Util.RANGE_MIN_OPERATIONS[1];
    }

    if (noProperPrefixForMinValueExists(input) && noProperSuffixForMaxValueExists(input)) {
        return Util.RANGE_MIN_OPERATIONS[3];
    }

    return Util.RANGE_MIN_OPERATIONS[2];
};

class Util {
    static NOT_POSSIBLE = -1;
    static RANGE_MIN_OPERATIONS = [0, 1, 2, 3];
}

/**
 * @param {string} input
 * @return {boolean}
 */
function isSorted(input) {
    for (let i = 1; i < input.length; ++i) {
        if (input[i - 1] > input[i]) {
            return false;
        }
    }
    return true;
}

/**
 * @param {string} input
 * @return {boolean}
 */
function minValueIsAtStart(input) {
    for (let i = 1; i < input.length; ++i) {
        if (input[0] > input[i]) {
            return false;
        }
    }
    return true;
}

/**
 * @param {string} input
 * @return {boolean}
 */
function maxValueIsAtEnd(input) {
    for (let i = 0; i < input.length - 1; ++i) {
        if (input[input.length - 1] < input[i]) {
            return false;
        }
    }
    return true;
}

/**
 * @param {string} input
 * @return {boolean}
 */
function noProperPrefixForMinValueExists(input) {
    for (let i = 1; i < input.length; ++i) {
        if (input[0] <= input[i]) {
            return false;
        }
    }
    return true;
}

/**
 * @param {string} input
 * @return {boolean}
 */
function noProperSuffixForMaxValueExists(input) {
    for (let i = input.length - 2; i >= 0; --i) {
        if (input[input.length - 1] >= input[i]) {
            return false;
        }
    }
    return true;
}

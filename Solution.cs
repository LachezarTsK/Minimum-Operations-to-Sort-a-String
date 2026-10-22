
using System;

public class Solution
{
    private static readonly int NOT_POSSIBLE = -1;
    private static readonly int[] RANGE_MIN_OPERATIONS = { 0, 1, 2, 3 };

    public int MinOperations(string input)
    {
        if (input.Length == 2 && input[0] > input[1])
        {
            return NOT_POSSIBLE;
        }

        if (IsSorted(input))
        {
            return RANGE_MIN_OPERATIONS[0];
        }

        if (MinValueIsAtStart(input) || MaxValueIsAtEnd(input))
        {
            return RANGE_MIN_OPERATIONS[1];
        }

        if (NoProperPrefixForMinValueExists(input) && NoProperSuffixForMaxValueExists(input))
        {
            return RANGE_MIN_OPERATIONS[3];
        }

        return RANGE_MIN_OPERATIONS[2];
    }

    private static bool IsSorted(string input)
    {
        for (int i = 1; i < input.Length; ++i)
        {
            if (input[i - 1] > input[i])
            {
                return false;
            }
        }
        return true;
    }

    private static bool MinValueIsAtStart(string input)
    {
        for (int i = 1; i < input.Length; ++i)
        {
            if (input[0] > input[i])
            {
                return false;
            }
        }
        return true;
    }

    private static bool MaxValueIsAtEnd(string input)
    {
        for (int i = 0; i < input.Length - 1; ++i)
        {
            if (input[input.Length - 1] < input[i])
            {
                return false;
            }
        }
        return true;
    }

    private static bool NoProperPrefixForMinValueExists(string input)
    {
        for (int i = 1; i < input.Length; ++i)
        {
            if (input[0] <= input[i])
            {
                return false;
            }
        }
        return true;
    }

    private static bool NoProperSuffixForMaxValueExists(string input)
    {
        for (int i = input.Length - 2; i >= 0; --i)
        {
            if (input[input.Length - 1] >= input[i])
            {
                return false;
            }
        }
        return true;
    }
}

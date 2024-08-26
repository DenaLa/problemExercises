# Is Subsequence

## Concepts
Two Pointer, String, Dynamic Programming

## Instructions
Given two strings ```s``` and ```t```, return ```true``` if ```s``` is a subsequence of ```t```, or false otherwise.

A **subsequence** of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

## Given Hints
N/A

## Intuition
- We need to track both where we are in string ```s``` and in string ```t```.
- We can check the letters in ```s``` against ```t```, and only move forward in ```s``` when we spot it in ```t```
- We should go on the assumption that we won't find a subsequence, and then return ```true``` if we do

## Step By Step Solution
1. Make a conditional statement. If ```s``` is empty, return ```true```
2. At the end of the method, return ```false```
3. Create an int ```checkLen``` that starts at 0.
4. Create a for each loop that runs on the logic ```char c : t.toCharArray()```
   1. Create a char called ```check``` that checks the character in ```s``` that is at index ```checkLen```
   2. If ```c``` is ever equal to ```check```, then increment ```checkLen``` by 1
   3. If ```checkLen``` ever reached the length of ```s```, it means that we have found a sub sequence. Return ```true```
5. That should be everything you need to solve this problem

## Explaining the Solution
- Our reason for returning ```true``` if ```s``` is empty is because an empty string is a subset of any string.

## Code
```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int checkLen = 0;

        for (char c : t.toCharArray()) {
            char check = s.charAt(checkLen);
            if (c == check) {
                checkLen++;
            }
            if (checkLen == s.length()) {
                return true;
            }
        }

        return false;
    }
}
```

## Time Complexity
O(n)

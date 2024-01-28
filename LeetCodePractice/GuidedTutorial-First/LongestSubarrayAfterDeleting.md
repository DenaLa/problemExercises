# Longest Subarray of 1's After Deleting One Element
## Concepts Explored
_Arrays, Dynamic Programming, Sliding Window_

## Instructions
Given a binary array **nums**, you should delete one element from it.

Return the size of the _longest non-empty subarray_ containing only 1's in the resulting array. Return 0 if there is no such subarray.

### Guidance
- We have to maintain a sliding window where there is at most _1_ zero in it. If we get more than one zero, we have to exclude it.

## Solution
1. Create these variables:
   * **ans**, which will store our answer to this question
   * **zeroes,** which counts the amount of zeroes we have encountered in our window
   * **A**, which serves as the back half of our window. It will only move when we have seen more than one zero
   * **B,** which will be created for our for loop, will serve as the front half of our window that searches for zeroes to omit.
2. We will iterate through the array. While we do so, we watch for these conditions:
   * If **nums[B] == 0**, increment **zeroes** by one.
   * If **zeroes** reaches 2, then we start a while loop where the condition is that **zeroes** is equals to 2. In this loop, we begin moving **A** to shrink our window.
   * If **A** encounters a zero, reduce **zeroes** by 1. This will allow us to exit the while loop.
   * Right as we exit the while loop, compare the current value of **ans** by the distance between **B** and **A.** Whichever one is bigger becomes our new answer.
3. Once we have iterated through the entire loop, return **ans**

## Why does this work?
Our sliding window has no set size. We are growing and shrinking our window based on how many zeroes we have encountered, with the value at **A** being excluded from the window's range. 

## Time complexity
The time complexity of this algorithm is _O(n)_. We need to iterate through the entire array before our objective is complete. Even though **A** does also iterate through the array, it only goes through a part of the elements (That we will call m) _m+n_ is still _O(n)._

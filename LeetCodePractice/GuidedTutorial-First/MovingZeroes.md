# Moving Zeroes
## Concepts Explored
_Arrays, Two Pointers_

## Instructions
Given an int array **nums,** move all 0s in the array to the end while maintaining the order of the non-zero elements. You must edit the array in-place

### Guidance
We should use a two pointer approach. One pointer should go through the array, and the other should only deal with the non-zero elements of the array.

## Solution
1. Create a pointer **A.** This pointer starts at 0. **A** only moves when our second pointer, **I,** sees a nonzero number
2. Iterate through our loop. While we iterate at our loop, check to see if our current element at **I** is zero or not. If it isn't, then we place the element at **I** at the index of **A.** After we do this, we increment **A** by 1.
   * **A** and **I** do not move at the same time, so **A** will always trail behind **I**
3. Once we exit our loop, all of our nonzero elements should have been moved to the front of the array with their order preserved. Populate the rest of the array with zeroes.

## Why does this work?
**A** keeps the place in the array where we drop off the non-zero elements that **I** sees. We can pretend **A** is the index of another array of the same length of **nums**. Its array only gets populated when **I** finds a nonzero number in **nums** own array. Once **I** is finished, **A** will still be in the middle of its own array. But we know that the numbers that have est to be added are zeroes. Thus we add zeroes to the end of **A's** "array".

## Time complexity
The time complexity of this algorithm is _O(n)_. We go through a loop of length _n_ and go through a loop of length _n_, which is functionally _O(n)_

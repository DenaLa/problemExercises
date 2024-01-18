# Max Consecutive Ones III
## Concepts Explored
_ _

## Instructions
Given a binary array **nums** and an integer **k**, return the maximum number of consecutive 1's in the array if you can flip at most **k** zeroes.

### Guidance
- We only want to flip zeroes if they's extend an existing string of ones.
- In any string of ones, they can never have more than **k** additional ones.
- This is a sliding window problem, but we don't have a fixed window. The window grows and shrinks based on the amount of zeroes we are allowed to flip
  - And even in this case, we don't need to physically flip zeros, we just have to count them in a sense
- Shrinking and expanding the window is based on how many zeores we can still flip

## Solution
1. We need to create several variables:
   * Pointer **A,** that points at the start. Elements at **A** are _excluded_ from our window.
   * Pointer **B,** that points at the end. Elements at **B** are _included_ in our window
   * An int variable **flipped,** that tells us how many zeroes we have flipped so far.
2. We will use a while loop to iterate through the array. **B** will act as our iterator.
3. While we iterate throug the loop, we will ensure certain things:
   * **B** increments every loop.
   * If **B** runs into a zero, we increment **flipped** by 1.
   * Once **flipped** is greater than our variable **k** (Which is telling us how many zeroes we are allowed to flip in a given string) we begin checking for another condition: If there are **zeroes** at **A**.
   * If there is a zero at **A**, reduce **flipped** by 1. This is because **A** acts as an excluded bound in our window. You can then increment **A** by 1.
     * _**A** only increments when **flipped** is more than **k**._ In every other instance, it is stationary.
4. Once the iteration is complete, **B** and **A** should be at a certain distance from each other that contains the longest amount of consecutive ones, also accounting for the flipped zeroes. Return **B-A**.


## Why does this work?
Our window can grow and shrink in size, depending on the amount of zeroes we are allowed, and the amount of zeroes that extend a sequence of ones. **B** always moves because it is looking for zeroes to add, and **A** moves once it finds an extra zero in order to keep our window within the appropriate range.

## Time complexity
The time complexity of this algorithm is _O(n)_. It needs to iterate through the whole array before our objective is complete.

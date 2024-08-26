# Max Number of K-Sum Pairs
## Concepts Explored
_Arrays, Two Pointers, Sorting _

## Instructions
You are given an int array **nums** and an integer **k.** You can pick out two numbers in this array that add up to **k** and discard them. Return the number of times you can do this.

### Guidance
We want to find pairs in **nums** that equal to **k**. A way we can do that is by comparing sums, and then moving on once we have one. This ensures we don't get doubles.

## Solution
1. We want to approach this with two pointers, one from the end and the other from the start. In order to do this, we first need to sort the array. We can do this with **Arrays.sort().**
2. Create these variables:
   * An int **count** to count the number of times we can remove pairs
   * A pointer **A** for te beginning of the array, and a pointer **B** for the end of it
3. We will now use a while loop to traverse the array. We'll keep going for as long as **A** is less than **B**. While we loop , we'll do the following:
   * We will calculate the sum of **nums[A]** and **nums[B]**.
   * If the sum is equals to **k,** we increment **count** and **A** by 1, and bring **B** back by 1
   * If the sum is less than **k,** we move **A** forward by one space
   * If the sum is more than **k,** we move **B** back by one space.
4. At the end, we should have the proper **count** to return.

## Why does this work?
By sorting **nums**, we create a clear set of upper and lower bounds for **A** and **B** to look at. If our sum is too big, it's because the number at **B** is too big, so we move it to a smaller number. If our sum is too small, it's because the number at **B** is too small, so we move it to a bigger number.

## Time complexity
The time complexity of this algorithm is _O(n)_. There is a chance that we must taverse the entire Array before completing our objective.

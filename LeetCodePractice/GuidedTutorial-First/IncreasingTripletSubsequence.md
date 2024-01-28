# Increasing Triplet Subsequence
## Concepts Explored
_Arrays, Greedy Algorithm_

## Instructions
Gien an int array **nums**, return **true** if there exists a set of triple indices _i, j, k_ such that _i < j < k_, and _n[i] < n[j] < n[k]._ Otherwise, return **false.**

### Guidance
If there is an increasing triplet in the array, that means that there are at least two smallest values in the array. In order to find our triplet, we would need to see if there are two smallest numbers such that the smaller of the two comes before the middle. If there are any numbers bigger than that, then we'll be able to confirm there is an Increasing Triplet

## Solution
1. Create two int variables **A** and **B**. We will test these variables against the elements in the array in order to find the pair of smallest variables. Set them to be the maximum possible integer in java.
2. We will now iterate through the array, and look for 3 conditions
   * If our current element is less than or equal to **A**, then set **A** to that element. **A**
   * If our current element isn't less than or equal to **A,** but it _is_ less than or equal to **B,** set B to that element
   * If our current element isn't less than **A**, and it isn't less than **B**, that means it's greater than both. At this point, we can return **true**
3. If we somehow manage to go through the entire array without the third condition being met, that means there is no increasing triplet. Return **false.**


## Why does this work?
As said before, if there is an increasing triplet in the array, then there will be two elements **A** and **B** where **A<B.** If we find an element that is greater than both **A** and **B**, then we get a set of integers that fulfill **A<B<C.**

We are going through the array in order. This means criteria for **A** will always be met before criteria for **B**, and criteria for **B** will always be met before criteria for C. By setting both **A** and **B** to MAX_INT, we ensure that we can catch any number that is possible in the array. We also test for elements that are less than or equal to because there might be multiple of the same number in an array (Which can interrupt our increasing triplet.)

## Time complexity
The time complexity of this algorithm is _O(n)_ because we need to iterate through the entire loop to complete our objective.

# Find Pivot Index
## Concepts Explored
_Arrays, Prefix Sum_

## Instructions
Given an array of integers **nums**, calculate the pivot index of this array.

The **_pivot index_** is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is **0** because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.

### Guidance
- Create a **prefixSum** array and a **suffixSum** array and calculate the respective prefix and suffix sums
- After that, all you need to do is compare the sums at inex **i** to fid the pivot index


## Solution
1. For ease of process, create a variable **len** to store the length of **nums**
2. Create arrays **pre** and **suf** of length **len** to serve as the arrays of the prefix and suffix sums.
3. Set the first element of **pre** to the first element of **nums.** Set the last element of **suf** to the last element of **nums**
4. We will now use a for loop to populate both arrays. We want to populate the arrays with the prefixSums and suffixSums respectively
   * For the prefix sum, add the previous element of **pre** to the current element of **nums**
   * For the suffix sum, make your index always equal to **len - iterator - 1**. Add the next element of **suf** with the current element of **nums**
  5. After we finish populating the arrays, compare the sums of **pre** and **suff.** If they end up equaling the same thing, return **i.**
  6. If none of those conditions fit, return -1

## Why does this work?
The prefix sum is the sum of all numbers before the element at **i.** The suffix sum is the sum of all elements after **i.** So, if you compare the two, and see that two sums are the same, it means you found the pivot sum.

## Time complexity
The time complexity of this algorithm is _O(n)_. We need to iterate through the entire array in order to complete our objective. While we do have a second loop, it is outside the first one, and is functionally _O(n)_

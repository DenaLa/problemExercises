# Merge Sorted Array

## Instructions
Given 2 int arrays (num1 and num2) with variables m and n representing the amount of elements in each, merge the two into one sorted array.
The sorted array should be contained in num1. num1 will be the length m + n to accomodate.

### Guidance
Instead of looking at two arrays, look at the two elements from each array

## Solution
- We will have 3 pointers:
  * Pointer A will watch the valid elements in nums1
  * Pointer B will watch the valid elements in nums2
  * Pointer C will watch the entire array
- Each pointer will start at the end of their given array

1. First, we check to see if n is 0. If n is 0, then there is no need for us to merge anything, since there are no valid elements in nums2
2. Secondly, since nums2 is guarenteed to be the shorter array, we rely on it to set our pace. We use it as our validator, and we use a while loop to facilitate for it
3. We start at the end of each "array", we are comparing nums1[A] and nums2[B], while C is at the end of their shared array.
4. We check to see that A is within bounds, and then test an additional option
   * If nums1[A] > nums2[B], we set the value of nums1[C] (which in our first loop, is all the way at the end in the free space), to the value of nums[A] (which at the start, will be at the end of the list of valid elements in nums1). We then have both pointers iterate one step backwards. B remains untouched, as we are still checking its value
   * If nums[A] < nums2[B], then we set the value of nums1[C] to nums[B], and have the pointers iterate one step backwards
5. By the time we are all through nums2, we should have a merged and sorted list

## Why does this work?
Since our goal is to not only merge, but sort our arrays, it makes sense to start at the back. Each array is already sorted in ascending order, and nums1's trailing elements are all not valid, giving us the space to shuffle elements around freely within them.

We depend on a while loop because we only want to move specific elements after we complete a task with that element, and not move simply after every loop.

Because we are sorting, we want to compare the valid elements to each other. Since we are sorting backwards, the largest element will always get placed where C is located. We want to ensure A is still within bounds of the array so we do not run into a problem with an out of bounds error. By drawing from elements in both arrays, we end up merging them together as we work with this algorithm.

## Time complexity
The time complexity of this algorithm is _O(n + m)_, because the method we use to sort and merge will go through the entirety of nums1. Each statement we perform in nums1 is O(1), and nums1 is m+n elements long.

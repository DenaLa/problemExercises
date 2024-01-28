# Remove Duplicates in a Sorted Array
## Concepts Explored
Arrays, Two Pointer

## Instructions
Given an ascending sorted int array (***nums***), remove the duplicates in-place. The original order of the elements should be preserved. Return k, the amount of unique elements in nums.

While the first k elements should be the unique elements in order, but the values at the trailing end of the array do not matter.
### Guidance
Since the array is sorted, all the duplicates are next to each other

Since we are modifying in-place, we need to use two pointers. One pointer tracks all the elements in the arrays, and one pointer points only to the unique elements.

## Solution
- We have two pointers
  * ***Pointer I*** increments throughout the entire array
  * ***Pointer A*** increments only through unique elements. It _only_ moves when a unique element is encountered.
  * Both ***I*** and ***A*** should start at 1
 
1. Set up a loop where ***I*** watches the array
2. While we go through the array, check to see if ***nums[I]*** > ***nums[A-1]***
   * ***nums[I] > nums[A]*** means that the element ***I** is currently looking at is greater than the element right before the element ***A*** is looking at.
3. If this condition is met, replace the element at ***nums[A]*** with the element at ***nums[I].***, and increment ***A**. Otherwise, only increment ***I***
4. Since ***A*** is only moved when we meet a unique element, we can use it as our value of ***k***. Return ***A***

## Why does this work?
The two pointers are necessary for modifying in place, as we need one to track the array in general, and one to keep track of every unique element before we reach any duplicates. The reason ***A*** starts at 1, instead of 0, is because the first element in the array is always going to be the first time that number appears, meaning that we do not need to check it or modify it at all.

Throughout our trip through the array, if at any point ***nums[I] > nums[A-1]***, it means we have encountered a new element. We know this because the array is sorted, and all of the duplicates will be right after each other. We check using ***A-1*** and not ***A***, because ***A*** is being used as the index point for where a new, unique element should be stored should we encounter it later down the line, and the element before ***A*** should already be unique. If ***A***'s current element is a duplicate of the element before it, then it would not be caught by our algorithm.

The values in the array after the first ***k*** unique values do not matter, so we do not need to concern ourselves with what they are.

## Time Complexity
The time complexity of this algorithm is _O(n),_ since we need to iterate throughout the entire array to complete our objective.

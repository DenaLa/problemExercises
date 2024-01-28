# Unique Number of Occurrences
## Concepts Explored
_Arrays, Hash Tables_

## Instructions
Given an array of integers **arr**, return **true** if the number of occurrences of each value in the array is unique or **false** otherwise.

### Guidance
- We can use a Hash Map to keep track of the number of occurences within **arr**
- From there, we can use a Hash Set to check for unique occurences

## Solution
1. Create a Hash Map **A** to keep track of the occurences in **arr**
2. Iterate through **arr**. Check the following:
   * If the current value of **arr** doesn't exist in **A,** then place it in **A** with a value of **1**
   * If it does exist in **A,** simply update the value of it my incrementing it by one.
3. Create a Hash Set **check** to check the values of the occurences in **A**. Because each element of a Hash Set needs to be unique, it will not record duplicates.
4. Return the value of **check.size() == A.size()** to get your answer.

## Why does this work?
As stated previously, every element of a Hash Set needs to be unique. The way we've set up our algorithm, our Hash Map will have a size equal to the unique number of elements in array **arrs**. If they all have unique occurence numbers, then the our Hash Set should record them all, making the size of the set and the size of the map the same.

## Time complexity
The time complexity of this algorithm is _O(n)_. We need to iterate through entire arrays and maps to complet our objective, but non of them are nested.

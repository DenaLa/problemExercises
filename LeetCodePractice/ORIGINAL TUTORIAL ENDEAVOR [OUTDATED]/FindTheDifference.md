# Find the Difference of Two Arrays
## Concepts Explored
_Arrays, Hash Tables_

## Instructions
Given two 0-indexed integer arrays **nums1** and **nums2**, return a list answer of size 2 where:

- **answer[0]** is a list of all distinct integers in nums1 which are not present in nums2.
- **answer[1]** is a list of all distinct integers in nums2 which are not present in nums1.

Note that the integers in the lists may be returned in any order.

### Guidance
- Check **nums1** and **nums2** against each other utilizing HashSets
- The Typing of the return value is a bit tricky, but don't worry.

## Solution
1. Create our **result** list. We instantiate it as **List<List<Integer>> result = new ArrayList<>();**
2. Create two HashSets, **set1** and **set2**. We will populate these two sets in order to check **nums1** and **nums2** against each other.
3. Add two arrayLists to **result**. We will store our results in these.
4. Populate both **set1** and **set2** with the elements of **nums1** and **nums2** respectively with a ForEach loop each.
5. With another two ForEach loops, check to see is elements of one set are present in the other. If not, add the element to the proper place in **result**
6. At the end, return **result.**

## Why does this work?
This problem is very simple. All it requires is getting our data into Data Structure that we can work with, in this case being HashSets and ArrayLists. These two data structures provide functionality that makes our job very easy.

## Time complexity
The time complexity of this algorithm is _O(n)_. We repeatedly iterate through several arrays and sets to get our results, but ultimately, it is still _O(n)_ because none of the loops are nested.

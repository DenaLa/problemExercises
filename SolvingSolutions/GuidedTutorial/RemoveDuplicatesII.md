# Remove Duplicates in a Sorted Array II
## Concepts Explored
Arrays, Two Pointers
## Instructions
Given an int array ***nums*** that is sorted in ascending order, remove duplicates so that at most, each element only appears twice. You must keep the same ascending sort order. The results must be placed in the first ***k*** elements of ***nums***

***k*** will be the amount of elements that only appear _twice_ at most, meaning that ***k*** is the amount of valid elements in the array. After ***k***, the contents of the array do not matter.
### Guidance
Since the array is sorted, all instances of an element will appear right next to each other

One good way to solve this is by keeping track of the array, keeping track of the unique elements, and keeping track of the amount of times one element appears in order to work with it when it appears more than once
## Solution
There are two ways to solve this problem. One way to solve it is the intuitive way, where we keep track of the number of occurances and modif the array based on that. The other is a small modification of our previous Remove Duplicates code that accounts for an extra element to be allowed.
### Solution A: Count the Clones
- We will ave these variables:
  * ***Pointer I*** will iterate through the array. It starts at 1
  * ***Pointer A*** will only keep track of our unique elements. It starts at 1
  * ***Clones*** will keep track of how many extra appearances our unique elements make. It starts at 0

1. Use a for loop to iterate the array
2. As we go through the array, we check to see if ***nums[A]*** == ***nums[A-1]***
   * If it does, that means that the value at ***nums[A]*** has at least one other appearance, and means it has appeared twice in total. Increment ***clones*** by 1
   * If it doesn't, that means this is the first time we have encountered this element, meaning the amount of extra appearances is 0. Set ***clones*** back to 0;
3. Next, we check to see if the amount of **clones** is less than 2 (In other words, 1 extra appearance). If it is, then make it so that ***nums[A] == nums[I]***. Increment ***A*** by 1.
4. Since ***A*** only moves when our conditions are met, we can use it as a counter. Return ***A***

### Solution B: Modify The First Algorithm
The original algorithm is as follows:

- We have two pointers
  * ***Pointer I*** increments throughout the entire array
  * ***Pointer A*** increments only through unique elements. It _only_ moves when a unique element is encountered.
  * Both ***I*** and ***A*** should start at 1
 
1. Set up a loop where ***I*** watches the array
2. While we go through the array, check to see if ***nums[I]*** > ***nums[A-1]***
   * ***nums[I] > nums[A]*** means that the element ***I** is currently looking at is greater than the element right before the element ***A*** is looking at.
3. If this condition is met, replace the element at ***nums[A]*** with the element at ***nums[I].***, and increment ***A**. Otherwise, only increment ***I***
4. Since ***A*** is only moved when we meet a unique element, we can use it as our value of ***k***. Return ***A***

To modify this, we make a simple change

- ***A*** and ***I*** both start at 2 now
-  ***nums[A-1]*** becomes ***nums[A-2]***


## Why does this work?
### Clone vs Appearances
Me counting Extra Appearances as opposed to Total Appearances is entirely a preference thing. The logic flowed better in my mind when I did this. To appear twice at most, each unique element would need 1 clone of itself.

### Solution A
We are always checking behind our current place to see if we have at most two of the same element in a given array. We start at the index of 1 because the first element of the array is always going to be unique, and it's just a matter of seeing whether or not it has a duplicate appearance or not.

If the amount of clones is less than two, we replace the element at ***A*** with the element at ***I***. We do this because of the way we are incrementing through the array and the way we count clones. We iterate the array one at a time, checking to see if each element behind ***I*** is the same. If it is, we add a duplicate to the counter, but if it isn't we reset the counter to zero. The element behind means that we've encountered a new unique element, and that we need to begin counting clones again.

We copy values whenever ***clones*** is less than 2. Clones being less than 2 just means that there is only one extra appearance, and that it is safe to copy values to the current value of ***A***. Once again, ***A*** is watching the unique elements, and is in a sense holding a spot for both unique elements and their clones to reside once we find them later in the array. When ***clones == 0*** it means its the first instance of a new element, so we put it in ***A's*** position. When ***clones == 1***, it means that we have found the first clone and will put it in the appropriate position. When ***clones == 2*** it means we have found an extra element, and we don't need to place it anywhere.

Since ***A***, again, only increments when we meet our criteria, we can have it pull double duty for returning ***k***

### Solution B
This is a modified version of our code for a previous version of this problem, where no extra appearances are allowed. In this version of the problem, one clone of a number is allowed. And so, we accomodate for that by starting at index 2 and looking behind 2 spaces instead of one. The logic behind this is that the first element in the array will always be unique, and the second element will always either be a clone, or different. Checking 2 spaces behind not only accomodates for allowing 1 clone, but for our further starting position.

We check two spaces behing ***A*** because ***A*** is where our unique elements and its clones should be placed, meaning that all the elements before it are guarenteed to be valid elements.

Since ***A***, again, only increments when we meet our criteria, we can have it pull double duty for returning ***k***

## Time Complexity
Both algorithms are _O(n)_, because both algorithms go completely through the array to complete their objectives.

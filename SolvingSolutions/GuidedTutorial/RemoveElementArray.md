# Remove Element from Array

## Instructions
Given an int array (***nums***), and a value to remove (***val***), remove all instances of this value in-place. While you do this, count how many numbers are not our forbidden value, and return that number. **The elements following the first instances of our non forbidden elements do not matter.**
_To code in place means to not allocate any extra space in order to arrange your array. You are given what you are given and must work around this restriction. This does save space in a program overall, so it is useful_

## Guidance
We don't need to "remove" elements per se. Since the trailing elements (the elements after our allowed elements) do not matter, we can have these elements be whatever we want.

There are two ways to solve this. You can either swap the elements to put the forbidden value at the end of the array (requiring two passes), or we can copy the elements in-place as we iterate through the array normally. Both solutions will be shown.

## Solution

### Solution A: Swapping
- While this solution does get the job done, it requires another seperate pass of the array in order to return ***k***

- There will be three variables:
  * ***Pointer A*** will start at the end of our array
  * ***Pointer B*** will start at the beginning of our array
  * Amount will be our ***k***
 
1. Ensure that the array isn't completely empty
2. Since ***B*** will be traveling forward and A will be traveling backwards, we will keep looping until each pointer overlaps. Since they increment at different times, there is almost no worry they will pass each other in most examples
   * However, in some examples they WILL pass each other, making this solution not optimal.
3. Inside our while loop, we check the following:
   * If ***nums[B] != val***, we move onto the next element in our array
   * If ***nums[B] == val***, we check the following:
     * If ***nums[A] (which starts at the end of the array) != val***, we swap the positions of ***nums[B]*** and ***nums[A]***. This puts our unwanted value in the back. Increment ***B*** forward, and ***A*** backward.
     * If ***nums[A] == val***, then we leave it alone. We increment backwards to see if the next number will be better to swap.
4. Doing it this way means that there is no reliable way to increment for ***K***. However, because you swapped values instead of copying them, you can now count the amount of elements that do not equal ***val*** by going throug the loop again.
5. Return k

### Solution B: Copying
- This solution overcomes the problems of the last one, and is done with significantly less code

- There will be these variable and concepts:
  * ***Pointer A*** will be doing double duty. It will serve as our pointer in our array, only moving when we encounter a value in ***nums*** that is not ***val***
  * We will be using a for each loop, making that loop an unofficial second pointer that is looking through the elements.
 
1. Set ***A*** to 0.
2. Initiate the for each loop.
3. While inside this loop, check to see if the current element being looked at in ***nums*** is equal to ***val***
   * If it is, don't do anything
   * If it isn't, then copy the value of the currently looked at element and place it into ***nums[A]***. Then, increment ***A*** forward.
4. Since ***A*** only increments when we have something that doesn't equal ***val***, we can return it as ***k***


## Why does it work?
The first solution goes the swapping route, which works for the most part but has a fatal flaw of the possibility of the two pointers passing each other while ***B*** checks for values to move to the back of the array. It also cannot count for ***k*** while it works, and needs an additonal loop for it. This makes the code run longer than neccesarry.

The second solution is very compact. I will refer to the loop as ***Pointer I*** for this explanation.

***Pointer I*** is concerned with checking each element in the array if it is equal to ***val***, and nothing else. This gets us through the entire array without worries of going out of bounds. ***Pointer A*** serves a different purpose. ***Pointer A*** points to an area in the array that has not been overwritten yet, making it available for later elements in the array to be put inside. If there is an element later in the array that is not equal to ***val***, it can be brought closer to the start of the array thanks to ***Pointer A** only incrementing when that is the case. In essence, ***Pointer A*** is marking an available spot for a value to migrate to. 
Since the values of the elements beyond our ***non-val** elements don't matter, we are free to have duplicates, and don't neccesarily need to move our ***val*** elements anywhere.

## Time Complexity
The first solution has a time complexity of _O(2n)._ There is a chance that ***A*** never moves, meaning B will go through the array in its entirety. The extra loop needed to count the amount also goes through the array in its entirety, meaning there are two _O(n)_ algorithms one after the other.

The second solution has a time complexity of _O(n)._ It only needs to go through the loop once to complete both objectives.

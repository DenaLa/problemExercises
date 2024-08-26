# Move Zeroes

## Concepts
Array,Too Pointer

## Instructions
Given an integer array ```nums```, move all ```0```'s to the end of it while maintaining the relative order of the non-zero elements.

_Note that you must do this in-place without making a copy of the array._

## Given Hints
- **In-place** means we should not be allocating any space for extra array. But we are allowed to modify the existing array. However, as a first step, try coming up with a solution that makes use of additional space. For this problem as well, first apply the idea discussed using an additional array and the in-place solution will pop up eventually.
- A **two-pointer** approach could be helpful here. The idea would be to have one pointer for iterating the array and another pointer that just works on the non-zero elements of the array.

## Intuition
- While we want to move all the zeroes to the end of the array, nothing says we actually need to **save the values of zero that we want to move**

## Step By Step Solution
1. Create an int variable ```A``` that will keep track of our non-zero elements
2. Create a for each loop where we track int ```I``` in ```nums```
   1. If ```I != 0```, then we make ```nums[A]``` ```I```, and increment ```A``` by 1
3. After we go through the array the first time, we make a while loop. This time, we will go through the array startung at our value of ```A```. At every step, we want to make ```nums[A] = 0```, incrementing ```A``` by 1
4. After that, we are done

## Explaining the Solution
- ```A``` takes care of our nonzero elements, marking how many there are AND what part of the array to place a zero once we're done dealing with all of them

## Code
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int A = 0;

        for (int I : nums) {
            if (I != 0) {
                nums[A] = I;
                A++;
            }
        }

        while (A < nums.length) {
            nums[A] = 0;
            A++;
        }

    }
}
```

## Time Complexity
O(n)

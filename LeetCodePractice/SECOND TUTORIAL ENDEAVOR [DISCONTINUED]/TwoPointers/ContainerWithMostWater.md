# Container With Most Water

## Concepts
Array, Two Pointer, Greedy

## Instructions
You are given an integer array ```height``` of length ```n```. There are ```n``` vertical lines drawn such that the two endpoints of the ```ith``` line are ```(i, 0)``` and ```(i, height[i])```.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

**Return the maximum amount of water a container can store.**

Notice that you may not slant the container.

## Given Hints
- If you simulate the problem, it will be O(n^2) which is not efficient.
- Try to use two-pointers. Set one pointer to the left and one to the right of the array. Always move the pointer that points to the lower line.
- How can you calculate the amount of water at each step?

## Intuition
- The amount of water is just the area of a given space.
- We want to find the two greatest heights, but use the height of the shorter one in order to calculate the area. This is to keep the water contained within the container without spilling over the side.

## Step By Step Solution
1. Create three int variables, ```A``` that points to the beginning of the array, ```B``` that points to the end of the array, and ```area``` to keep track of the area of the container.
2. Return ```area``` at the very end of the method.
3. Create a while loop with the condition that ```A < B```
   1. Set an int variable ```min``` to the minimum value between ```height[A]``` and ```height[B]```
   2. Set the ```area``` to be the minimum between the current ```area``` and the new area calculated by ```min * (B - A)```
   3. If ```height[A]``` is less than ```height[B]```, increment ```A``` by one. Otherwise, decrease ```B``` by 1.
4. This should be enough to solve the problem

## Explaining the Solution
- There isn't anything to explain that has not been explained already.

## Code
```java
class Solution {
    public int maxArea(int[] height) {
        int A = 0, B = height.length - 1, area = 0;

        while (A < B) {
            int min = Math.min(height[A], height[B]);
            area = Math.max(area, min * (B - A));

            if (height[A] < height[B]) {
                A++;
            } else {
                B--;
            }
        }

        return area;
    }
}
```

## Time Complexity
O(n)

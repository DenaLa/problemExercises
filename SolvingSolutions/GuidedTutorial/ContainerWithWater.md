# Container With Most Water
## Concepts Explored
_Arrays, Two Pointers, Greedy Algorithm_

## Instructions
You are given an int array **height** of length **n**. There are **n** vertical lines of various heights. Find two lines that together with the length of the **array,** form a container, such that the container contains the most water. Return the maximum amount of water this container can store.

### Guidance
We want to find the greatest amount of water in a container, which is represented by a 2D Rectangle. This means we can easily solve this problem by finding the largest area. The real wquestion is how we would calculate the area, and how do we do that iteratively.

We want to keep track of the two tallest heights, so we will use two pointers.

## Solution
1. We starts off with three variables:
   * **max** which tracks the largest area we encounter
   * Pointer **A**, which starts at the beginning of the array.
   * Pointer **B**, which starts at the end of the array.
2. We need to iterate through the loop on the condition that the value of **A** is smaller than the value of **B.** While we loop, we check the following:
   * We check to see which element is smaller, **height[A]** or **height[B]**. This will help when calculating our area.
   * Update the maximum area by getting the length (distance between **height[A]** and **height[B]**) times the height (the smaller of the two heights that we found earlier) and comparing it to our current max.
   * If **height[A]** is less than **height[B]**, we move **A** forward. This is because we want to explore if there are any elements that are larger than **height[A]** that might give us a bigger area, despite moving closer to **B**
   * If **height[B]** is less than (or equal to) **height[A]**, then we move **B** back for the same reason.

## Why does this work?
As stated before, finding the most amount of water is just a matter of finding the largest area. The reason why we use the minimum height between **height[A]** and **height[B]** to find the area is for an intuitive reason: if we used the larger height then the water would spill out. In this case, our lowerbound determined what was possible for us.

## Time complexity
The time complexity of this algorithm is _O(n)_. While we come at the array from two different sides, overall we only traverse through it once.

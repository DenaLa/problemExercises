# Maximum Depth of Binary Tree

## Concepts Explored
_Tress, Binary Trees, Depth First Search_

## Instructions
Given the **root** of a binary tree, return its maximum depth.

A binary tree's _maximum depth_ is the number of nodes along the longest path from the root node down to the farthest leaf node.

### Guidance
- We can use depth first search and recursion to solve this issue

## Solution
1. Since we are using recursion, we need to establish a base case. In this case, it is preparing for the scenario that our **root** is null. If that is the case, return 0, since there is no height to it.
2. Next, we think about how we are spliting up our problem. We want to do depth first search, meaning that we want to keep exploring a branch on the tree until we hit a dead end. We can achieve this by using recursion.
3. We set two variables, **left** and **right.** These two variables will be used to travel the left and right sides of a branch, by calling _maxDepth_ again, only this time, you call it on the **root's** lef and right nodes respectively.
4. We return the value of _Math.max(**left**,**right**) + 1_ We add the 1 because we want to include our **root** in our height. Our base case returns 0, so in order to add the root where the null node came from, we add 1.
5. After every recursive call, we should get the correct number.

## Why does this work?
While we travel through the tree recursively, we will always stop and begin to unwind at our base case of returning 0. When we return outside of our base case, we return a value of compared numbers + 1. We are always keeping track of the root of origin, and including it in our counts even as values are returned off of the stack.

## Time complexity
The time complexity of this algorithm is _O(n)_. We traverse the entire tree looking for our answer.

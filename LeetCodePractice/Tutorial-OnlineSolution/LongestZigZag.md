# Longest ZigZag Path in a Binary Tree

## Concepts Explored
_Dynamic Programming, Tree, Binary Tree, DFS_

## Instructions
You are given the **root** of a binary tree.

A ZigZag path for a binary tree is defined as follow:

- Choose any node in the binary tree and a direction (right or left).
- If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
- Change the direction from right to left or from left to right.
- Repeat the second and third steps until you can't move in the tree.

Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest_ ZigZag path_ contained in that tree.


### Guidance
* When traveling with DFS, we don't need to stay in a straight line
* When we leave a recursive call, the code after it will execute.

## Solution
1. Let us create out DFS method first. It is a void method that takes in 3 parameters, our **root** node, the direction we want to go in in the form of char **dir,** and the current count of the zig zag, which is an int **count**
2. If the root is null, simply return
3. First, we check if our direction is left
   * If it is, check to see if our left node is actually empty. If it's not, call _DFS_ again, setting the root node to **root.left**, set the **dir** to 'r' for "right", and set the count to **count+1**
   * After that, we need to establish what happens when we exit that recursive call. We want to compare our current answer to the count that we got while traveling the tree, so we use _Math.max_ to check what is larger, **ans** or **count**
   * After that, we still want to check the right side to see if we can find a longer zig zag in that direction. If the right node isn't empty, call a _DFS_ call, this time with the parameters **root.right**, 'l', and 1. The assumption that we are making when we head right from a 'l' call is that we were already heading right to begin with, and didn't zig zag. This is why the counter restarts to 1
4. We do the same thing with the right side, but reversing the logic. For all the sub steps in _**3**_, reverse the directions
5. We are finished with our _DFS_ method. Now we return to our longestZigZag method.
6. Call _DFS_ with the parameters of **root**, 'l', and 0.
7. At the end, return ans.


## Why does this work?
There are several things that assure we will get the results we want:
  * When we call the method recursively, it will keep calling itself until it reaches its base case. When it does that, each call will unfurl in a sense. They exit themselves and continue onto the rest of the code. This allows us to call them and then set up things for when they are finished, such as evaluating our answer and looking into the alternate path
  * The fact that we account for the other path after traveling in our prefered direction is also another factor. It ennsures that we are checking everywhere we can before exiting for sure.
  * With the way our algorithm is set up, **ans** will always be evaluated and updated accordingly.

## Time complexity
The time complexity of this algorithm is _O(n)_. We need to travel through the entire tree before completing our objective.

# Leaf-Similar Trees

## Concepts Explored
_Trees, Binary Trees, Depth First Search_

## Instructions
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a _leaf value sequence_.

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return _true_ if and only if the two given trees with head nodes **root1** and **root2** are leaf-similar.

### Guidance
- A leaf is a node of a tree without any branches. i.e, the very end
- We can solve this by performing depth first search again, and recording the values of the leaves.


## Solution
1. We will convert our Depth First Search from [MaxDepthBinaryTree](https://github.com/DenaLa/problemExercises/blob/main/SolvingSolutions/GuidedTutorial/MaxDepthBinaryTree.md). This time, it sould be type _void_ instead of _int._
   * Change it so that the method accepts a **root** node and an array list **leaves** as input
   * If the root is null, return.
   * If the root is a leaf (the left and right nodes are null), then add the node's value to the array list and return
   * If neither of these conditions are met, then we call _DFS_ twice, for the root's right node and the root's left node.
2. In our _leafSimilar_ method, make two Array Lists. Ones called **leaveA** and **leavesB**. We will store the leaves in these
3. Call our _DFS_ method for both our **roots**
4. Since the _DFS_ deals with our primary objective, all we need to do is return if **leavesA** is equals to **leavesB**


## Why does this work?
We use Depth First Search to get to the leaves quickly, and keep track of their values in an array list since it is one of the easier data structures to manipulate. 

## Time complexity
The time complexity of this algorithm is _O(n)_. It is the sum of the size of the first tree and the size of the second tree, which is effectively _n_

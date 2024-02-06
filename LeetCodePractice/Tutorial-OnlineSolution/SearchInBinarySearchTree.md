# Search in a Binary Search Tree

## Concepts Explored
_Trees, Binary Trees, Binary Search Trees_

## Instructions
You are given the **root** of a binary search tree (BST) and an integer **val**.

Find the node in the _BST_ that the node's value equals **val** and return the subtree rooted with that node. If such a node does not exist, return _null_.

### Guidance
- A Binary Search Tree has the following properties according to [GeeksForGeeks](https://www.geeksforgeeks.org/binary-search-tree-data-structure/):
  * The left subtree of a node contains only nodes with keys lesser than the node’s key.
  * The right subtree of a node contains only nodes with keys greater than the node’s key.
  * The left and right subtree each must also be a binary search tree.
- Since we know the Tree is basically in order from left to right, we can traverse it in relationship to whether or **val** is larger or smaller than the val of the current node
  

## Solution
1. If the root is null, return null
2. If the root's value is the value we're looking for, return the value of the root
3. If the root's value is more than the value we want, we are too far right. Recursively call our method, turning to **root.left** to find our value
4. Otherwise, if none of these conditions are met, recursively call our method but instead look to the right subtree to look for our value

## Why does this work?
A binary search tree has values strictly less than the root's value on its left side, and values strictly more than its root's value on is right side. We compare our desired value to the value of the node we are currently looking at, and move either left or right depending on how our desired value compares to our node. And if we do find our value, we can safely return it.

## Time complexity
The time complexity of this algorithm is _O(n)_. There is the possibility of traversing the entire tree before we meet our objective, or not meeting it at all after traversing the whole thing

# Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

## Concepts Explored
_Trees, Binary Tree, DFS, BFS_

## Instructions
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

### Guidance


## Solution
1. First, let us create a method that will help us search the tree. we will call it _searchTree._ It will take root node, list, and integer as paramaters. The node is the root of the tree, the list is the list that stores the right side view, and the integer is the furthest depth we've explored in the tree
2. We create an if statement. If our list size is the same as the current depth, then we add our current node to the list. We are runing on the assumption that if we reach this state, we are viewing the rightmost node on the right side of our tree (which includes our root)
3. We explore the right side of our tree first. Recursively call _searchTree_ with the input of **root.right,** our list, and **depth+1**
4. We then want to explore the left side. Recursively call _searchTree_ with the input of **root.left**, our list and **depth+1**.
   * Note that the depth we insert here will _not_ be the depth that is the result of the recursive call to the right. It will be based on the depth that we entered into the first call of the method.
5. Return to our _rightSideView_ method. Create a list to hold the values of the nodes with a right side view, and call _searchTree_ with the parameters of **root**, the list, and a depth of 0.
6. At the end, return our list.

## Why does this work?
We check the right side of the tree first because we want the right side view. It is not guarenteed that that the entire branch will cover the entire tree, however. This is why we also check the left side; not only do we want to check the left side of the right branch, but if there is no right branch to speak of, then checking the left branch _would_ be the right side view.

## Time complexity
The time complexity of this algorithm is _O(n)_. We travel the entrie tree in search of our objective.

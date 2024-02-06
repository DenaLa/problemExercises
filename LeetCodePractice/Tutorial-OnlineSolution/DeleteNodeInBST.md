# Delete Node in a BST

## Concepts Explored
_Tree, Binary Tree, Binary Search Tree_

## Instructions
Given a **root** node reference of a BST and a **key**, delete the node with the given **key** in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

1. Search for a node to remove.
2. If the node is found, delete the node.
### Guidance


## Solution
1. First, we want to create a method that will help us get to the minimum node in a given subtree. Create the _getMin()_ methode that takes a node as a parameter. It's only algorithm is to keep setting **node** to **node.left** for as long as **node.left** is not null. It then returns that same **node**
2. For our method proper, if the root entered is null, return null.
3. First, let's establish three states: What we do when **root.val == key**, when **root.val < key,** and when **root.val > key**
   * in the case of **root.val < key,** we will recursively call our method, only this time traveling to the right node
   * In the case of **root.val > key** we will recursivel call our method, only this time traveling to the left node
   * In the case of **root.val = val**, we will start the deletion and replacement process
     - If the right of our root is null, return **root.left**. The same goes for vice versa
     - But if neither of those conditions are met, then we want to set our minNode to **root.right**. We want the right node due to the nature of how binary search trees are organized. Call our _getMin_ method with **root.right** as the parameter
     - Set **root.right** to a recursive call of _deleteNode_ where the parameters are **root.right** and **minNode.value**.
     - We then set the right and left of **minNode** to be the same left and right nodes of **root**
     - After that all that, we replace the value of **root** with the value of **minNode**
4. When we exit the conditions, we return our root.

## Why does this work?
- Setting our minNode preps the node that we want to replace our key with
- Due to the nature of binary search trees, we always want to grab the node to the right when we replace values. These value, by definition, should be larger than the node they are replacing but will fit in between the key's left node and the key's parent node
- When we call deleteNode recursively, we are essentially shifting the nodes up and replacing them up the tree.

## Time complexity
The time complexity of this algorithm is _O(logn)_. We determine which side of the tree we are working on based on the value of **key**. This means that we do not need to traverse the entire tree.

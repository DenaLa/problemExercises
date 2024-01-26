# Lowest Common Ancestor of a Binary Tree

## Concepts Explored
_Trees, Binary Trees, DFS_

## Instructions
iven a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of [LCA on Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor): _“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”_

### Guidance


## Solution
1. First, we will use an if statememnt to determine a few things. If our **root** is null, or our **root** equals **p** or **q**, then we reuturn our **root**
2. Otherwise, we create two TreeNode variables called **left** and **right.** We set these variables to a call of _lowestCommonAncestor_ with the respective node (**root.left** or **root.right**) being used instead of **root.** **p** and **q** remain the same.
3. After these two calls, we want to check if both our **right** and **left** nodes are empty. If neither node is _null,_ it means that we have found our LCA, and want to save it. Return **root**
4. Last but not least, if none of the conditons are met, we want to use a conditional operation to return either the value of **right** or the value of **left.** Our conditional looks like _return (left == null ? right : left)_

## Why does this work?
We perfrom DFS to look for our nodes, and record whether or not we find our **p** and **q** nodes. If we _do_ find both of them, then we return our **root**, and it is either rturned immediately (our **p** and **q** happened to be the very first right and left nodes), or it is saved in either **right** or **left** to be returned later. Our very last conditional statement (_return (left == null ? right : left)_) will check to see if **left** is null or not, and what to return if it is. In a lot of cases both **left** and **right** will be null at the same time. But, there are situations where only one of the other is null, in which the non null element contains our answer.

There is also the assumption that our **p** and **q** are nodes that exist within or tree. Because of this, if we do not find **p** or **q** on one side, but we find **p** or **q** on the other side, we can make the assumption that the LCA is whichever node we found first, since the nodes are allowed to be descendents of themselves.

## Time complexity
The time complexity of this algorithm is _O(h)_. our time complexity depends on the height of the tree.

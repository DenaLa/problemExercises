# Maximum Level Sum of a Binary Tree

## Concepts Explored
_Trees, Binary Trees, BFS, DFS_

## Instructions
Given the **root** of a binary tree, the level of its root is _1_, the level of its children is _2_, and so on.

Return the _smallest_ **level x** such that the _sum of all the values of nodes at level x is maximal._

### Guidance
- We want to see what level of the tree has the greatest sum.
- Calculate the sum for each level then find the level with the maximum sum.
- Use DFS or BFS to traverse the tree keeping the level of each node, and sum up those values with a map or a frequency array.

## Solution
1. Create 3 integer variables:
   * **level** marks the level of the tree we're on
   * **maxLevel** marks our desired level **x** that holds the largest sum
   * **maxSum** marks the largest sum that we've seen
2. Create a queue of TreeNodes that will hold the nodes at a specific level.
3. Add our root to this queue
4. Create a while loop with the constraint that our queue cannot be empty
5. While inside the loop, do the following
   * create the integers **levelSum** (starts at 0) and **levelSize** (size of the queue)
   * Create a for loop that loops for as long as i is less than the level size. While inide the for loop: 
     * Create a TreeNode **node** that we'll use to look at the current node. Set **node** to the top element of queue and remove it from the queue by using _poll_
     * Add the **node's** value to the level sum.
     * At the next step, we want to add the children of this node to the queue so that we can keep track of the next level's nodes. Add the respective left and right nodes to **queue** if they are not null. This marks the end of the for loop
  * We then check to see if the **levelSum** is larger than our **maxSum.** If it is, we set our **maxSum** to the level sum, and set our **maxLevel** (our desired level x) to the current level.
  * At the end of the while loop, increment level by 1
6. At the end of the method, return **maxLevel**

## Why does this work?
We are searching through the tree by Breadth instead of depth in this solution. We keep track of the levels, how big they are, what's in them, in the sums that they contain.

## Time complexity
The time complexity of this algorithm is _O(n)_. We need to travel the entire tree to reach our objective.

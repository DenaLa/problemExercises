# Count Good Nodes in Binary Tree

## Concepts Explored
_Trees, Binary Trees, Depth First Search, Breadth First Search_

## Instructions
Given a binary tree **root**, a node X in the tree is named **good** if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

### Guidance
- Use DFS (Depth First Search) to traverse the tree, and constantly keep track of the current path maximum.

## Solution
1. We are going to use DFS, and name the method that does it _travel_. Travel returns an integer, and takes in the root node and the maximum value as parameters
2. If the root is null, return _0._
3. Make a new variable called **newMax.** Compare our current max value to the value of the root. Whichever is bigger becomes the newMax value
4. Our return statement will be in several parts:
   * We use our conditional operator to return a value 1 or 0 depending on whether or not the root  value is larger than (or equal to) our current maximum. (In case you forgot, the conditional is _**[expression]** ? **[value if true]** : **[value if false]**_)
   * To that, we add the result of _travel(**root.left**, **neMax**)_ and _travel(**root.right**, **neMax**)_ to it. Why we do this will be explained in the next section.
5. All that is left is to call **travel(root, root.val)** in the _goodNodes_ method, and return its result

## Why does this work?
Again, we use recursion to perform a Depth First Search. Our _good nodes_ are defined by being greater than or equal too the highest value that we have seen so far, which explains our conditional, as well as updating our Max value when we encounter a larger value.

Our return statement in travel can look quite confusing, but its's simpler once you think about it. We can split it up into three parts:
  * _(root.val >= max ? 1:0)_ counts for the current node. Is it a good node or not?
  * _travel(root.left, newMax)_ counts for the left side of the current branch. What are the total amount of good nodes there?
  * _travel(root.right, newMax)_ counts for the right side of the current branch. Again, what are the total amount of good nodes there?

Recursion deals with taking larger problems and breaking them down into a simple, repeatable state that involves calling itself. So it's good to think of a problem like this not only in relation to basic case (Or, where the recursion will stop), but also in the generic case of each step. WHat is the state at the problem of ever step, and what is its relationship with the past and future steps? It's good to keep these in mind.

## Time complexity
The time complexity of this algorithm is _O(n)_. We need to travel through the entire tree to reach our objective.

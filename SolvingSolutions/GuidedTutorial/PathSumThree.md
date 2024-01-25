#Path Sum III

## Concepts Explored
_Trees, Binary Trees, Depth First Search_

## Instructions
Given the **root** of a binary tree and an integer **targetSum**, return the number of paths where the sum of the values along the path equals **targetSum**.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

### Guidance


## Solution
[Original Solution and Explanation](https://leetcode.com/problems/path-sum-iii/solutions/4274495/beats-100-00-of-users-with-java-easy-dfs-code-o-n-tc-with-explanation/?envType=study-plan-v2&envId=leetcode-75)
_While the original solution has its explanation attached, I challenged myself to not look at the explanation until I could fully understand the solution on my own_

1. Create a HashMap **map** and an int **count** as public variables within the entire class. Having them be global will help us with our calculations
   * Our HashMap is to keep track of all of our prefix sums. We will use these prefix sums to find which paths hold our sums. The keys will be **long** numbers, and the values will be **integer** values that keep track of how many times this number appears
   * Count is to just keep track of How Many pats led to our sum.
3. Initialize both **map** and **count** in our _patSum_ method. **count** should equal to 0.
4. We will need to call on another DFS method to travel through the tree and to record the information we want. Here is what we hould make sure of:
    * Our method takes in three inputs, the **root** node, the **targetSum**, and a **prefixSum**
    * This DFS method does not return anything, so it should be _void_
    * That being said, if the root is null, then we should exit the method with a return statement.
    * Add our **root's** value to the prefixSum.
    * We need to check two things:
      * If our **map** contains **prefixSum's** complement (**prefixSum - targetSum**), then that means there is at least one valid path that we want. We add the **value** of that key to **count**
      * If our **targetSum** equals our **prefixSum**, then we increment count by 1.
      * At the end of these checks, we update **map** to either update the count of the current **prefixSum**, or to add said **prefixSum** to it.
      * We then recursively travel down the left and right branches to explore more of the tree entering the respective node, the **prefixSum, ** and the **targetSum** as the parameters.
      * At the very end of _DFS,_ find our current **prefixSum** in our **map** and reduce its value by one. This is us backtracking after hitting a dead end.
5. With DFS defined, all that is left to return the count


## Why does this work?
First, we need to implement DFS to find the paths in the tree. Wile we travere the paths in the tree, we keep track of the prefix sums. For ever node we visit, we want to see if our node is a complement to the **prefixSum** that we can add to it and make our target sum. If it is, we check to see how many times it appears in the hash map. The number of times it has appears signifies that these are valid paths for the sum.

If the **prefixSum** is equal to the **targetSum,** that also indicates that it's a valid path. This time, we only increment by one.

When we are done checking those conditions, we add the **prefixSum** in the map, so that when we search other areas, we can have the **prefixSum** on hand to check the complements.

Getting to the end of our DFS method means that we've hit a dead end, and it's time to backtrack until we can find another valid path. This means we decrease the count of the prefix sums we have stored in our map, but do not remove them completely. They can appear on other branches.

## Time complexity
The time complexity of this algorithm is _O(n)_. We travel through the entire tree in rder to complete our objective

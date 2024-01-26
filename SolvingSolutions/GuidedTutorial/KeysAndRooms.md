# Keys and Rooms

## Concepts Explored
_DFS, BFS, Graph_

## Instructions
There are **n** rooms labeled from _0 to n - 1_ and all the rooms are locked except for room _0_. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array **rooms** where **rooms[i]** is the set of keys that you can obtain if you visited room **i**, return _true_ if you can visit all the rooms, or _false_ otherwise.

### Guidance
- You do not necessarily need to visit the rooms in order.

## Solution
1. Create an array **seen** that is the size of rooms. This will keep track of the rooms we've seen. 0 means a room hasn't been seen, 1 means a room has been seen
2. We need to create a custom _dfs_ method.
   * Our dfs method should take our rooms list, our seen array, and the current node (our index) that we're on in the graph
   * Since this dfs marks us entering a room, we set the value of **seen[node]** to 1
   * We then need to check the current room to see if there are keys we can use to enter a new room, Create a for loop that runs based on the amount of keys (elements) in our current room (list). In our foor loop, if there is a key for a room we haven't entered, we call _dfs_ to enter that room
     * In terms of programming, we make a forEach loop for each **child** node's value in **rooms.get(node)**. If **seen[child]** is a valid room, and it's value is 0, it means it hasn't been entered. We call _dfs_ with the new parameters **rooms**, **child,** and **seen.**
  * This is all DFS does
3. After _dfs_ finishes, we return _Arrays.stream(seen).allMatch(a -> a == 1)_.

## Why does this work?
- As stated before, our _dfs_ method is our room entering method. We set the room of the node to seen, and look at our keys (which are the elements in the ArrayList, the **child** in **rooms.get(node)**) And see which room has not been entered yet (which element of seen is still 0)


## Time complexity
The time complexity of this algorithm is _O(|V| + |E|)_. Even though we represent it as a list in the problem, we are stil traversing a graph by it's vertices and edges to reach our objective

# Reverse Linked List

## Concepts Explored
_Linked List_

## Instructions
Given the **head** of a singly linked list, reverse the list, and return the reversed list

### Guidance
- Reversing a linked list is sort of like rearranging an array
- We need to keep trackof our current node, the next node, and the previous node

## Solution
1. Create two nodes, **prev** and **next.** Set them both to null.
2. Create a while loop. This loop will depend on **head** not being null.
3. While inside the loop, we will do the following shuffling:
   * **next** is responsible for marking what node is the next node to check after we reverse our current node. At the very begining of each node, set **next** to **head.next**
   * next, we set **head.next**. Now that we've recorded the next node in our list, we can reverse our current node. Set **head.next** to **prev.** **prev** should be trailing behind head.
   * Next, we set **prev** in preperation to move **head.** **prev** should always be trailing behind **head,** being one node behind. Set **prev** to the current position of **head**
   * Finally, we set the position of **head** to the position of **next** to continue along the list.
4. After all of this, we return **prev.** This is because **head** is currently null, and **prev** will be in the last place **head** was valid.


## Why does this work?
We are keeping track of the previous, present, and next nodes in order to properly reverse the next node in the list. **next** ensures that we do not lose our next place. **prev** ensures that we don't lose our previous place that we want to connect to. and **head** is our current node that we are adjusting. With the way the algorithm is structured, this even takes care of cases where our **head** is null (Prev starts as null, and will simply return null), or when there are only two element (the loop will work as usual.)


## Time complexity
The time complexity of this algorithm is _O(n)_. We need to iterate through the entire linked list in order to complete our objective.

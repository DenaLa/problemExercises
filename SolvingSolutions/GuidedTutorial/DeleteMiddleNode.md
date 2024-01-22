# Delete the Middle Node of a Linked List

## Concepts Explored
_Linked List, Two Pointers_

## Instructions
You are given the **head** of a linked list. Delete the middle node, and return the **head** of the modified linked list.

The middle node of a linked list of size **n** is the **⌊n / 2⌋th** node from the start using _0-based_ indexing, where **⌊x⌋** denotes the largest integer less than or equal to **x**.

- _For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively._

### Guidance
- If a point with a speed **s** moves **n** units in a given time, a point with speed **2 * s** will move **2 * n** units at the same time. Can you use this to find the middle node of a linked list?
- If you are given the middle node, the node before it, and the node after it, how can you modify the linked list?

## Solution
**_Please note our code in this repository returns a different value than the solution for leetcode! This is so that we can show the middle value changing. This solution will provide the correct return value for leetcode, but the one in the actual code will be different, with a comment._**
1. If the **head** is null, or the next element of the head is **null,** return **null.** There is nothing to figure out.
2. Create a **dummy** node that starts outside of our linked list, and has its next node be our **head**
3. Create a **slow** node that will travel our linked list one node at a time. Set it to our dummy node
4. Create a **fast** node that will travel our linked list two nodes at a time. Set it to our dummy node
5. Create a while loop. It will continue looping for as long as **fast.next** _AND_ **fast.next.next** are not null (Meaning **fast** has a place to travel to still)
6. Have **slow** and **fast** travel at their speeds. **slow** will traverse the linked list one node at a time. **fast** will traverse it two nodes at a time.
7. Eventually, **fast** no longer has any place to go, and we exit the while loop. At this point, slow should be right before the halfway point. Change **slow's** next value so that it is **slow.next.next's** value. This effectively cuts out the middle of the Linked List.
8. Return **dummy.next.** This should return the **head**, which in the case of our cute node, would return the node after it.

## Why does this work?
The middle node of the linked list is essentially (n/2) where the result of that is rounded down. (Half of 4 is 2, but half of 5 is 2.5 rounded down to two.) It is the (n/2) index of the linked list. **Fast** goes 2x as fast through the list, which means it takes it half the time to finish the list as a node that is going through it one node at a time. So, for **slow** that is going one node at a time, it can only reach halfway through the linked list before **fast** gets to its cutoff point This puts it in the perfect position to skip over our middle node. Since we want to delete it, we just have **slow.next** be turned into **slow.next.next**, which makes it so that **slow** is now connected to it's next node's next node.

## Time complexity
The time complexity of this algorithm is _O(n)_. We iterate through half of the linked list, but that is still functionally _O(n)_

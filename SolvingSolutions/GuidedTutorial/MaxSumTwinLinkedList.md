# Maximum Twin Sum of a Linked List

## Concepts Explored
_Linked List, Stack, Two Pointer_

## Instructions
In a linked list of size **n**, where **n** is even, the **ith** node (0-indexed) of the linked list is known as the twin of the **(n-1-i)th** node, if _0 <= i <= (n / 2) - 1_.

*_ For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4._

The _twin sum_ is defined as the sum of a node and its twin.

Given the head **head** of a linked list with even **length**, _return the maximum twin sum of the linked list_.

### Guidance
- In simpler terms, the twin node is the node that is in the mirror position of a given node
- We can think of this problem like it's asking for the twin sums of the elements of an array
- We know that the nodes of the first half are twins of nodes in the second half, so try dividing the linked list in half and reverse the second half.

## Solution
1. We are going to use previous solutions that we used to both find the halfway point of a linked list, and reversing a linked list. For reversing a linked list, we will use the [method for reversing a linked list that we created last time](https://github.com/DenaLa/problemExercises/blob/main/SolvingSolutions/GuidedTutorial/ReversedLinkedList.md)
2. Create a variable to hold our answer called **ans.** Make a ListNode **slow** that will travel through our linked list one step at a time and a ListNode **fast** that will travel through it two steps at a time.
3. Use a while loop that depends on **fast** and **fast.next** not being null and iterate through the LinkedList. With the way both **fast** and **slow** travel, slow will end up at the beginning of the second half of our linked list.
4. Create a new variable **tail.** **Tail** will be the result of reversing the linked list from node **slow.** This is a bit of an abstraction for what we really want: to have a node at the end of our linked list that is able to travel backwards up to a certain point. In
5. In **tail's** linked list, the list ends at where **slow** is. Since the length of our Linked List is even, both halves have the same amount of nodes. Meaning, we can rely on using the fact that **tail** is not null to drive our while loop. This while loop will help us determine the highest twin sum
6. During our while loop, we will do these actions in the following order:
   * Compare **ans** to the sum of **head.val** an **tail.val**. Whichever one is larger is now the new **ans**
   * Bring **head** to **head.next**
   * Bring **tail** to **tail.next**
7. Return **ans**

## Why does this work?
Imagine this linked list was an array. In ordr to gt the twin sums for the array, you would a pointer pointing to the front of the array and the back. Then, we slowly go through the array one element at a time, adding the twin sums and keeping track of which one was the largest.

The same idea works for this linked list, but we need to do a little more work to get what we want. We need to break down the steps we use, and think about how to apply them to our linked list. We don't have indexes, so we manually find the half way point. We cannot normally travel backwards, so we reverse a portion of the linked list. We can't rely on indexes to go backwards or forwards, but we do have the **.next** property.

## Time complexity
The time complexity of this algorithm is _O(n)_. We need to iterate through the Linked List several times to complete our objective, but we never nest the loops in a way that compares the full list to an element of the list for each element of the list.

# Odd Even Linked List

## Concepts Explored
_Linked List_

## Instructions
Given the **head** of a singly linked list, group all the nodes with _odd indices_ together followed by the nodes with _even indices_, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

_You must solve the problem in O(1) extra space complexity and O(n) time complexity._

### Guidance


## Solution
_[This solution is also posted on Leetcode](https://leetcode.com/problems/odd-even-linked-list/solutions/4606332/very-simple-odd-even-solution-beats-100-of-java-users/)_
1. If the head is empty, return null
2. Create a node that will group our odd indexes and even indexes, named **odd** and **even**
3. Create a **dummy** node to keep place of the start of our even nodes. We will need it to attach our evens to our odds later
4. Create a while loop. It will loop for as long as **odd.next** and **even.next** are not null. It means the two of them still have a place to go, and are still in the linked list. Even if the next element isn't what we want to assign to their own next nodes, we only want to stop once one of them exits the list.
5. While we loop, we assign the next of **odd** by making it equal **odd.next.next**. This the "Skipping two places over" mentioned earlier. We do the same for **even**. Then, we move both **odd** and **even** to their new next nodes.
6. After we exit the while loop, we should properly have our odd indexed elements and our even indexed elements grouped up. **odd** should be at the end of our odd indexed element. Make **odd.next** equal to **dummy**, which is still sitting at the start of our even indexed elements.
7. All that's left is to return **head**.


## Why does this work?
The problem asks us to group up the odd indexed numbers with the even indexed ones, and then place the even group after the odd group. So naturally, we need to do just that.

A really easy way to think about this, is if we start at index 1 in this case, then the next odd indexed number (3) is two indexes away. So for every odd indexed number, just skip over the next index, and instead connect it to the index two spaces away. This also works for even indexes.

So for example, if you had a linked list of [1, 2, 3, 4], that you want to turn into [1, 3, 2, 4], You only need to have 1.next point to 3 instead of two, and 2.next point to 4 instead of 3. 3.next and 4.next will both point to null after our rearranging is done, which allows us to assign 3.next to 2. This gives us our newly ordered Linked List. 

## Time complexity
The time complexity of this algorithm is _O(n)_. We need to iterate through the entire linked list in order to complete our objective.

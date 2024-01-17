# Is Subsequence
## Concepts Explored
_Strings, Two Pointers, Dynamic Programming_

## Instructions
Given two strings **s** and **t**, return **true** if **s** is a subsequence of **t**, or **false** otherwise.

A subsequence of a string is a new string formed from the original string by deleting some (or none) of the characters without disturbing the relative positions of the other characters.

### Guidance
Using two pointers will be helpful in this case. Since we want to see if **s** is a subsequence of **t**, we should have one pointer deal with **t,** and one deal with seeing if **s** is in **t**

## Solution
1. We will create a pointer **A** to keep track of the elements of **s** that are present in **t**. It starts at 0.
2. First, we check to see if **s**. is empty. If it's empty, it technically is a subsequence of **t**. Return true.
3. Second, we will iterate through **t**. We are looking for two conditions while we do this:
   * **A** will be pointing at the current character in **S** that we want to check. If our current element of **t** matches the element **A** is looking at, we increment **A** by one in order to have it check for the next character.
   * If **A** at any point equals the length of **s,** it means that elements of **s** are in **t**, and are in the same order. Return **true**
4. If none of these conditions are met, return **false.**

## Why does this work?
In order for **s** to be a subsequence of **t**, **t** needs to contain all elements of **s** in the same exact order that they appear. We can keep track of that with our pointer **A.** **A** is watching **s**, and due to the nature of how it increments, it will only go through **s** in order. Since we are also incrementing through **t** in order, we ensure any elements we encounter in **t** that it shares with **s** will also be in order. **A** only moves forward when we see an element in **t** that matches the one it is currently looking at in **s**. If **A** is the same length as **s,** it means that it has seen all elements of **s** in **t** in order.

## Time complexity
The time complexity of this algorithm is _O(n)_. We have to iterate throug our entire loop before our objective is complete.

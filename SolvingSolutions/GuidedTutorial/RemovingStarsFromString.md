# Removing Stars From a String
## Concepts Explored
_Strings, Stack, Simulation_

## Instructions
You are given a string **s**, which contains stars *.

In one operation, you can:

    Choose a star in s.
    Remove the closest non-star character to its left, as well as remove the star itself.

Return the string after all stars have been removed.

**Note:**
- The input will be generated such that the operation is always possible.
- It can be shown that the resulting string will always be unique.

### Guidance
- What data structure could we use to efficiently perform these removals?
- We could use a stack to store the characters. Pop one character off the stack at each star. Otherwise, we push the character onto the stack.

## Solution
While I prefer to use the method that uses a string builder, I also want to show a solution with a proper stack to demonstrate how one works.

### Solution A: With A Stack
1. If the string is empty, simply return ""
2. Create a StringBuilder **sb** and a Stack **st.** **sb** will help us in returning our string.
3. Use a ForEach loop to iterate through our string. While we do this, do the following:
   * If **c** is not a star, we push onto the stack
   * If **c** _is_ a star, as long as our stack isn't empty, we pop the last element from it.
   * Do this until we are done going through our string.
4. If **st** ends up empty after all of this, return ""
5. If it isnt, append all elements of it onto **sb** using a while loop.
6. Since stacks are a _LIFO_ structure, we will need to reverse the characters in **sb**. Thankfully, String Builders come with a built in reverse method.
7. Return the reverse of **sb**. Make sure you use the _toString()_ method to return the correct data type.


### Solution B: No Stacks
1. If the string is empty, return ""
2. Create a String Builder **sb.**
3. Use a ForEach loop to go through our string. While inside, do the following:
   * If the character **c** is not a star, append **c** to **sb**
   * If it is a star, delete the character at the end of **sb**
4. Once this is done, you should have your final string. Return **sb.toString()**

## Why does this work?
Stacks are a LIFO structure that can only be manipulated from the top. Pushing elements onto a stack puts them on top, and popping them removes them from the top. We don't actually need to put the stars on the Stack; all we need to do is remove the last thing we put on the stack.

We can use this same line of thinking with our second solution. But instead of using a stack, we just use a StringBuilder

## Time complexity
The time complexity of this algorithm is _O(n)_. However, do to the amount of looping we do in the first solution, the second solution ends up being faster.

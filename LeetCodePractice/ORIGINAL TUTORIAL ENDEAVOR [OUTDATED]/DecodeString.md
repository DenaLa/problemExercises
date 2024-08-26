# Decode String
## Concepts Explored
_String, Stack, Recursion_

## Instructions
Given an encoded string, return its decoded string.

The encoding rule is: _k[encoded_string]_, where the encoded_string inside the square brackets is being repeated exactly **k** times. Note that **k **is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, **k**. For example, there will not be input like _3a_ or _2[4]_.

The test cases are generated so that the length of the output will never exceed 105.

### Guidance
- What conditions do you need to check for? What are those conditions marked by?
- How will you keep track of your string and count?

## Solution
1. Create these variables:
   * A stack **repeats** to store the number of repeats a string sequence needs to do
   * A stack **str** to hold our StringBuilders that we use to build our new string
   * A StringBuilder **sb** to hold our the most current state of our decoded string
   * An int **count** to keep track of the processed **k** amount of repitition a string has to do
2. Iterate trhough our string with a for each loop. While we do this, we will check for the following:
   * Is our current character a number? Then we need to convert it for **count.**
     * We do this with the formula _count * 10 + (c - '0')._ Not only will it account for turning our character value into the actual numerical value, it will account for our number being longer than a single digit.
  * Is it the start of our new string sequence? This is marked by **c** being **[**. If it is, we need to prepare to accept a new string
    * Put our current **count** on the top of our **repeats** stack. Reset the **count** to 0. This is so we can accept the next **count** when the time comes.
    * Put our current Decoded String In Process on our **str** stack. Reset **sb** to being empty. This is so we can accept the next String Sequence when the time comes.
  * Is it a part of our current string sequence? Then just append it to **sb**
    * This step should come at the end of checking every other condition, as a simple else statement.
  * Is it the end of our new string sequence? If so, we need to do the following:
    * Prepare our **k** by popping the value of **repeats** onto it. We will use this to populate the string
    * Create a temporary StringBuilder **temp** to put our current String Sequence **sb** onto.
    * Get our Decoded String In Progress and pop it onto **sb**
    * Create a while loop with **k** being more than **0**. As our bound. As long as that condition lasts, append the sequence in **temp** onto our Decoded String In Progress **sb**
3. Eventually, you will have your decoded string. Return **sb.toString()**

## Why does this work?
We break down the algorithm into the Conditions we need to meet in order to take action. We categorize what encountering each character means, and how to properly tell our algorithm the action it should take in order to properly decode our string. It is not necessarily done in a linear order, since at the beginning of our string, the steps we take do not seem to make sense. It is about looking at the steps in a more generic way and putting them together on a case by case basis.

## Time complexity
The time complexity of this algorithm is _O(n)_. We need to iterate through the entire string in order to complete our objective.

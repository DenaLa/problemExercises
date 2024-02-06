# Merge Strings Alternatively
## Concepts
Strings, Two Pointer
## Instructions
Given 2 strings ***word1*** and ***word2***, merge the strings by letter in alternating order, starting with ***word1***. If one string is longer than the other, append the extra onto the back of the merge string. Return the merged string.
### Guidance
Look at the individual letters instead of the whole word. Work one step at a time instead of trying to get a final result all at once.
## Solution
There are two ways to solve this problem, with or without a StringBuilder class. Using StringBuilder makes the whole thing a lot faster
### No StringBuilder
- We will have two variables:
  * **_Merged_** which acts as our final merged string
  * **_Shorter_** which holds the length of the shorter word
 
1. Declare a for loop to run for the length of the shorter word
2. At each pass, concatonate the ith letter of _**word1**_ and **_word2_** onto _**merged**_ in that order.
3. At the end, check which sting is longer, and concatonate the rest of the word onto **_merged_**
   * In order to do this, concatonate the substring of the word, starting from the value of **_shorter_**
4. Return **_merged_**

### StringBuilder
- We will have two variables:
  * **_Merged_** which acts as our final merged string. This time, it's a string builder instead of an empty string
  * **_Shorter_** which holds the length of the shorter word
 
1. Declare a for loop to run for the length of the shorter word
2. At each pass, use the StringBuilder function .append() to append _**word1**_ and **_word2_** onto **_merged_** in that order.
3. At append both the remainder of **_word1_** and **_word2_** onto **_merged_**. Since one of these words is empty, appending them both at once will only result in the longer word's extra letters being appended.
   * make sure to apply the .toString() function so that you can return the value properly.

## Why does this work?
This algorithm is very simple, and only requires placing letters into a new string. We choose to let the shorter word dictate how long the loop goes so that we don't run out of bounds. Even though this algorithm runs very quickly, it is much faster to use a StringBuilder than it is to do things with a normal string. Conversely, when we do use normal strings, it is faster to check to see which bit of strings to append instead of appending both.

## Time Complexity
Both solutions run on _O(n)_ time, since the for loop will have to run to completion in order to fulfil our objective.

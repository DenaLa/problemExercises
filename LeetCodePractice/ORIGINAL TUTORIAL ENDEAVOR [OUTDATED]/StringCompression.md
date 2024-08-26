# String Compression
## Concepts Explored
_Strings, Two Pointers_

## Instructions
You are given a char array **chars**. You must compress it with the following algorithm:

- Go through **chars.** In an empty string **s**, for each _group of consecutive characters:_
  * If the group's length is 1, append the character
  * If the group's length is more than one, then append the character and the ammount of times it appears.
- Do not return **s**. Instead, overwrite values in **char** with the values in **s.**
  * If the number is not a single digit number, each digit of the number should take up its own index.
- Return the length of the new array. You must write the algorithm so that you only use extra space that is constance

### Guidance
The groups of characters are consecutive. Think about how you can not only count them, but bypass the duplicates of a character.
We are modifying **chars** in place. This means that the actual length of chars might not match the length of our "new array". Think of how you can keep track of the amount of elements you are overwriting in **chars**

## Solution
1. Create a variable to hold the length of the new array in. For this, we will refer to it as **newLen**, and it starts at 0.
2. We need to iterate through the array. As we do this, we must do the following:
   * create a char variable **check** that holds the current char group value that we are counting
   * create a new int variable **count** that will count the amount of times **check** appears in this array. We achieve this with a while loop that has two conditions: our current element being the one we're checking, and **I** still being within bounds of the array
   * After we do this, we have to overwrite values in **chars** with out new information.
     * **newLen** acts as our second pointer in this case, keeping the place of where we need to put new information. Put the value of **check** at **chars[newLen]**, and increment **newLen** by 1.
     * If **count** is more than one, then we also need to "append" it to our new array. Turn **count** into a char array, then place each element of that char array into **chars,** right where **newLen** is pointing. Increment **newLen** for each digit.
3. Once the loop is finish, all there's left to do is return **newLen**

## Why does this work?
**newLen** is the length of our "new" array, and thus is always pointing to the end of it. **I** iterates through our given array, traveling over it to record new characters and document how man times each character appears. This naturally leads to it ending with a value that is the length of the array.

The while loop serves to not only count how many characters we have in a group, but also as a way to bypass all the extra characters. It gets us to the next new character to record.

We turn **count** into a char array in order to actually put it into our char array.

## Time complexity
The time complexity of this algorithm is _O(n)_. While there is a nested loop, the inner loop travels _with_ the outer one, and not independently.

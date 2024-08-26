# Reverse Vowels in a String
## Concepts Explored
_Strings, Two Pointers_

## Instructions
Given a string **s**, reverse the vowels in it while leaving the consonant in place. Return the new string.

### Guidance
Vowels can be any case

How would you go about identifying a vowel? Think about what you would do intuitively if you were going step by step.

## Solution
1. Create a StringBuilder **sb** to act as our new space to build our new string. **s** will go untouched and unedited
2. We will create two pointers. **A** will start at the beginning of our string, and **B** will start at the end.
3. We will create a String **vowels** that contains every vowel, uppercase and lowercase
4. We now will make a while loop. We want to continue looping until **A** passes **B**
5. Move both pointers towards each other until they hit a vowel with while loops.
   * To do this, check to see that A has not passed B, and that the current element A or B is pointing at is not a vowel
6. Once we _do_ encounter a value, simply switch the positions in our StringBuilder **sb,** using our string **s** as reference.
7. Once the objective is complete, return **sb.toString()**

## Why does this work?
We use pointers to watch vowels at both ends, and each of them will stop moving and wait at a vowel once they encounter one. Once they both encounter one, they swap and then repeat the process of travelling until they see another vowel. They **do not move in unison,** which is why this algorithm works.

In this particular algorithm, using a StringBuilder helps to keep code more concise: instead of needing a temporary element to hold our swapped values, we just edit our StringBuilder according to our reference String.

## Time complexity
The time complexity of this algorithm is _O(n)_. While there are multiple loops, no loop individually goes the entire length of the array. However, in total, the distance traveled by each loop is _n._

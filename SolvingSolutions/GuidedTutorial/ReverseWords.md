# Reverse Words in a String
## Concepts Explored
_Two Pointers, Strings_

## Instructions
Given a sentence **s,** reverse the order of the words If the sentence has multiple spaces, trailing spaces, or preceeding spaces, we want to get rid of them. There should only be one space between words and no trailing or preceeding space

### Guidance
Try to remove all the spaces in the String before you work with it. Doing so will allow you to control where spaces go in the future.

## Solution
1. First we create a StringBuilder **sb** in order to manipulate strings easier
2. Then, we split our string **s** by the regex _"\\s+"_. This will split our sentence by erasing _every single instance of a whitespace._ Put the results of this split into an array **A**
3. Then, we loop backwards from the end of our array **A**, and append the elements to **sb**, while also appending a space between.
4. As a final touch, we use StringBuilder's **.trim()** function to get rid of the extra trailing space.

## Why does this work?
We completely get rid of all spaces to make it so that we can add spaces at our discretion. The regex **"\\s"** defines a single whitespace. but by adding a **+**, it will target _every_ whitespace in the string. So when we split our string, it will devour every whitespace it can find and split our sentence accordingly. By doing this, it gives us the liberty to re-add whitespaces as we please

We technically do have two pointers: The one that follows StringBuilder's **append** function (Always at the end of the SB) and the one for the loop that tracks our elements in **A.** This allows us to add words to the end of **sb** freely as we travel backwards through our initial sentence

## Time complexity
The time complexity of this algorithm is _O(n),_ since one loop through the array is required in order to complete our objective.

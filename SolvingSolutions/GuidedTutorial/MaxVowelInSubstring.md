# Maximum Number of Vowels in a Substring of Given Length
## Concepts Explored
_Strings, Sliding Windows_

## Instructions
Given a string **s** and an integer **k**, return the maximum number of vowel letters in any substring of **s** with length **k**.

### Guidance
We are going to be using a sliding window. We want to look at a range of elements, and update the maximum amount of vowels in each element ba

## Solution
1. First, we create a custom function that allows us to see if a character is a vowel or not.
2. Then, we create variables that will keep track of the current count of vowels, and the maximum amount of vowels we've seen
3. We place our window of length **k** at the beginning of the array, and count how many vowels are present within. We then make this our baseline **maxVowels** number.
4. To slide our window, we make our iterator **i** start at **k**, and slowly increment the value up, checking on the values from **(i-k)+1** to **k.**
5. If we encounter a new vowel in our window, we increment **count**. Conversely, if we leave a vowel behind (in **s[i-k]**), we reduce **count** by 1.
6. We then compare our **maxVowels** to our **count**, and make **maxVowel** to whichever number is highest.
7. At the end, we should have our final **maxVowels**

## Why does this work?
We use the concept of a sliding window in order to count our vowels. We place the window at the begining and count the vowels there, and slowly slide it across, adding to and subtracting from **count** as we gain and lose vowels. We need to establish our baseline, which we do by counting the vowels in the first **k** elements of our string, and then after that we place our iterator at the further end of our frame. We keep the size/length of our window in mind as we consider which elements have been added and which have been removed, and update accordingly to get our final result. 

## Time complexity
The time complexity of this algorithm is _O(n)_. We need to go through the entire loop in order to complete our objective.

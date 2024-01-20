# Determine if Two Strings Are Close
## Concepts Explored
_Hash Tables, Strings, Sorting, Counting_

## Instructions
Two strings are considered close if you can attain one from the other using the following operations:

    Operation 1: Swap any two existing characters.
        For example, a b c d e -> a e c d b (Swap B and E)
    Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
        For example, a a c a b b -> b b c b a a (all a's turn into b's, and all b's turn into a's)

You can use the operations on either string as many times as necessary.

Given two strings, **word1** and **word2**, return _true_ if **word1** and **word2** are close, and _false_ otherwise.

### Guidance
- Operation 1 allows you to freely reorder the string
- Operation 2 allows you to freely reassign the letters' frequencies.

## Solution
1. If **word1** and **word2** are different lengths, then they are not close by our definition of the word. Return _false_
2. On the flip side, if **word1** and **word2** are the exact same, then they are close by our definition of the word. Return _true_
3. Create two arrays of size 26 called **freq1** and **freq2**. We will be using these arrays to check the _frequency_ of appearances of letters in each word.
4. Set up a loop for as long as the length of one of our words. Since they need to be the same length, in this case it does not matter which word you use. While we loop, do the following:
   * Use the format of _**arrayName[wordName.charAt(i) - 'a']**_ to find the "index" of a particular letter. Increment the value of that space by 1. The reason this formatting works is because we are taking advantage of the fact that each char value has an interger value associated with it. This allows us to go to the indexes that we want. _(For example, Say we want to increment the value that represents the frequency of 'b'. 'b' has a value of 2. 'a' has a value of 1. If we do 'b'-'a', we will get 1. Since 'b' is the second letter of the alphabet, it will be the second element in the array, and thus, at index 1.)_
5. We will now check to see if each word has the same set of characters. For this part, it doesn't matther if the frequencies are the _same,_ just that that the letters _exist_ in both words. This is to comply with our definition of close.
   * We check this by ensuring that no frequency has a mismatch where the frequency in one letter is over 0, while the frequency of that same letter in the other word is 0. If this does occure, return _false._
6. After we ensure our words have the same set of letters, sort the arrays. We do this because in compliance with our rules, overall the total amount of frequencies should be the same. (For example, if you wanted to do a swap between bb and aa, both **b** and **a** need to appear twice.)
7. After this, return the value of **Arrays.equals(freq1, freq2)**. If the frequencies are the same it will return true. If it is false, it will return false.

## Why does this work?
We create our arrays with the knowledge that there are only 26 letters in the alphabet. We mentally assign each letter to an index in the array in order to keep track of how often the letters appear.

In order for the two words to be close by this porblem's definition, they need to share the same set of letters. The letters need to exist in both words to faciltate the swapping of letters or the transformation of existing letters into existing letters.

Frequencies need to match, not by letter by letter basis, but just as a whole. In order for the transformation to work, ou would need to find strings of letters with the same frequency. if you cannot find that, then the words are not close.

## Time complexity
The time complexity of this algorithm is _O(nlogn)_. Arrays.sort() is a _O(nlogn)_ time complexity. The rest of the algorithm has a _O(n)_ time complexity because of the traversal of arrays. Although the n in Array.sort() and in our own algorithm are different, by the conventions of Big O, they are both n. Thus, a _O(nlogn)_ time.

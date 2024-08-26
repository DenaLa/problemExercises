# Reverse Words in a String

## Concepts
Two Pointers, String

## Instructions
Given an input string ```s```, reverse the order of the words.

A **word** is defined as a sequence of non-space characters. The **words** in ```s``` will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that ```s``` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

## Given Hints
N/A

## Intuition
- Since there is no need to modify anything in place, we can just create a new sentence with a new string.
- We need a way to split the sentence by spaces, since the spaces indicate where the words are.

## Step By Step Solution
1. Create a String Builder ```sb``` and a new string array ```sentence```. To form ```sentence```, we use the the string function _split()_ and split by the delimiter ```\\s+```
   * This will seperate them by whitespace, which will be explained later.
3. We then use a simple for loop that travels from the end of ```sentence``` to the beginning. We append the elements of ```sentence``` to ```sb``` in reverse order, while also appending a space after each word.
4. After we finish creating our reverse sentence, we return ```sb.toString().trim()```. We call on _trim()_ in order to get rid of the extra whitespace at the end of our sentence put on by our last append.

## Explaining the Solution
- ```\\s+``` is what we use determine how we split our sentence by. ```\s``` is a regular expression that denotes _whitespace_, and when we write it in a string, we need to write it as ```\\s``` so that it is recognized as an expression and not just translated into whitespcae. The ```+``` sign indicated that we want to skip over _all_ whitespace. So if there are multiple whitespace, all of them will be skipped until it reaches the first non-whitespace character

## Code
```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sentence = s.split("\\s+");

        for (int i = sentence.length - 1; i > -1; i--) {
            sb.append(sentence[i]).append(" ");
        }

        return sb.toString().trim();
    }
}
```


## Time Complexity
O(n)

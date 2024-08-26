# Merge Strings Alternately

## Concepts
Two Pointer, String

## Instructions
You are given two strings **word1** and **word2**. Merge the strings by adding letters in alternating order, starting with **word1**. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

## Given Hints
- Use two pointers, one pointer for each string. Alternately choose the character from each pointer, and move the pointer upwards.

## Intuition
- We want to merge the strings letter by letter. We can do this easily by placing our characters letter by letter in a new string with a loop.
- To avoid going out of bounds, we want to make sure we know the length of the shorter word

## Step By Step Solution
1. Create a StringBuilder **sb**. We will use this to build our new string
2. Create an int variable **len**. We want to store the length of the shorter word in this variable.
3. Create a for loop. It will loop as long as the iterator is smaller than **len**
4. While we iterate through the loop, we append to **sb.** We append the character at **i** to our **sb**. Forst we append **word1's** character, then **word2**'s
5. Finally, we will return our **sb** as a string. We return **sb.append(word1.substring(len)).append(word2.substring(len)).toString()**


## Parts of the Solution Explained
- At step 5, our return statement might be confusing. Here is the breakdown:
  *  _sb.append()_ will append the parameter in the parentheses to our string builder. It is possible to chain these append statements
  *  _.substring()_ is a method that allows us to isolate a part of a string. When we insert just **len,** we are telling the substring to start at the value of **len.** **len** will always be at the end of the shorter word, so with the way our return statement is set up, it will only return the leftover letters.
  *  _toString()_ is a method that converts our StringBuilder to a string. 


## Code
```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len = Math.min(word1.length(),word2.length());

        for(int i = 0; i< len; i++){
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }

        return sb.append(word1.substring(len)).append(word2.substring(len)).toString();
    }
}

```


## Time Complexity
O(n)

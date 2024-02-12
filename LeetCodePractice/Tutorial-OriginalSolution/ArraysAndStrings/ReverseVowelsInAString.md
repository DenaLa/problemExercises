# Reverse Vowels of a String

## Concepts
Two Pointer, String


## Instructions
Given a string ```s```, reverse only all the vowels in the string and return it.

The vowels are _'a', 'e', 'i', 'o', and 'u',_ and they can appear in both lower and upper cases, more than once.

## Given Hints
N/A

## Intuition
- To swap vowels, we want to look at the string and travel in two orders, from beginning to end, and from end to beginning.
- So, as we are traveling in these two directions, we want to keep moving until we find a vowel. When we find a vowel at both ends, we stop and swap them.
- The placement of vowels is not always mirrored in a word. So instead of moving both ends at the same time, we want to make our move from one end, find a vowel, then make our move from the other end. And when we find both vowels from both ends, we will swap.
- Naturally, we stop when the we meet in the middle.

## Step By Step Solution
1. Create a String ```vowels``` that contains all vowels, lowercase and uppercase.
2. Create a StringBuilder ```sb``` built from our String ```s```
3. Create two in variables ```A``` and ```B```. ```A``` will be 0, and ```B``` will be the length of ```s``` minus 1
4. We create a while loop. Our condition for the loop is that ```A``` is less than ```B```
   1. We create two more while loops, nested inside this first one. These while loops are responsible for moving ```A``` and ```B``` to vowels, and stopping when they reach them. The condition for each of them is that ```A < B && (vowels.indexOf(sb.charAt(```**A OR B**```)) == -1)```. In the respective while loop, either increment ```A``` by 1 or decrease ```B``` by 1 for as long as the loop runs.
   2. Once those loops are finished, we swap the vowels that both ```A``` and ```B``` are at. To do this, we use ```sb```'s _setCharAt()_ method and set it to a vowel in ```s```. We do it in the format of ```sb.setCharAt(```**A OR B** ```, s.charAt(```**B OR A**```));```
   3. Increment ```A``` by 1 and decrese ```B``` by 1.
5. At the very end, the vowels should be swapped. return ```sb.toString```

## Explaining the Solution
- We use a string builder instead of modifying ```s``` in place in order to take advantage of the original placement of ```s```' vowels.
- Our while loops do not make the time complexity exponential. We are still only traveling through the string for as many characters there are in ```s```

## Code
```java
class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder(s);
        int A = 0, B = s.length() - 1;

        while (A < B) {
            while (A < B && (vowels.indexOf(sb.charAt(A)) == -1)) {
                A++;
            }
            while (A < B && (vowels.indexOf(sb.charAt(B)) == -1)) {
                B--;
            }

            sb.setCharAt(A, s.charAt(B));
            sb.setCharAt(B, s.charAt(A));
            A++;
            B--;
        }

        return sb.toString();
    }
}
```


## Time Complexity
O(n)

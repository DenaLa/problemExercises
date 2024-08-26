# (Problem Title)
## Concepts
Two Pointer, String

## Instructions
Given an array of characters ```chars```, compress it using the following algorithm:

Begin with an empty string ```s```. For each group of consecutive repeating characters in ```chars```:

- If the group's length is ```1```, append the character to ```s```.
- Otherwise, append the character followed by the group's length.

The compressed string ```s``` should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

## Given Hints
- How do you know if you are at the end of a consecutive group of characters?

## Intuition
- This is a two pointer problem, so we need two pointers. One keeps track of the index as we edit the char array in place, the other actually goes through the array to get the proper data.
  * So, one represents the final length of our "new array", and the other is just going through the old one.
- At the end of a consecutive group of letters, we'll hit a new letter. So, we need to keep track of the letter we're currently looking at so we know when to make the switch
- We need to also keep track of how many of a single letter is repeating, then reset it once we hit our new set of letters

## Step By Step Solution
1. Create an int variable ```finalLen```. We want to return this value as well, so add it to the end of the method. This will be the new length of our "new array"
2. Create a for loop. This for loop will have the parameters ```(int i = 0; i < chars.length;)```. We don't add ```i++``` at the end because we want to manipulate ```i``` in a specific way. While in our for loop, do the following:
   1. Create an int variable ```count``` and set it to 0.
   2. Create a char variable ```current``` and set it to ```chars[i]```
   3. Create a while loop. This loop operates on the logic of ```(i < chars.length && chars[i] == current)```. While in this loop, incrememnt ```count``` by 1, and incrememnt ```i``` by 1.
   4. This loop breaks when ```char[i]``` is no longer ```current```. When this happens, we want to make ```chars[finalLen] = current```. After we do this, we increment ```finalLen``` by 1.
   5. We then add an if stantment to see if ```count > 1```. If it is, we want to add it to our "new" array
      * We create a for each loop with the condition ```(char c : String.valueOf(count).toCharArray()) ```. In this for each loop, we have ```chars[finalLen] = c;``, and then increment ``finalLen``` by 1.
3. That will be it for our solution

## Explaining the Solution
- Our pointers are ```i``` (Goes through the whole array) and ```finalLen``` (Marks the end of our "new array" that the question asks for)
- ```while (i < chars.length && chars[i] == current)``` marks 2 conditions: Our first pointer is still within the bounds of the array, and that the current character in the array matches the character we are checking for
- Our if statement and second for each loop fulfil several things:
  * If ```count``` is more than one, the question asks that we put it in our new array
  * If ```count``` is longer than one digit, then the question asks that we seperate the digits into different elements. When we create our char array, each place gets it's own element inside of it.

## Code
```java
class Solution {
    public int compress(char[] chars) {
        int finalLen = 0;

        for (int i = 0; i < chars.length;) {
            int count = 0;
            char current = chars[i];
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }
            chars[finalLen] = current;
            finalLen++;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[finalLen] = c;
                    finalLen++;
                }
            }
        }

        return finalLen;

    }
}
```

## Time Complexity
O(n)

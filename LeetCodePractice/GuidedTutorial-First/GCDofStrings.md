# Greatest Common Denominator of Strings
## Concepts Explored
_Math, Strings_

## Instructions
For two strings s and t, it is said s is divisible by t if (s = t + t + .... + t) where t is concatonated with itself one or more times

Given two strings str1 and str2, return x, which will serve as the longest string that can divide both str1 and str2.

### Guidance
Since we're looking at the GCD, it means that str1 and str2 contain the same letters in some form. So we can use prefixes to determing what the GCD is by seeing what is the longest prefix we can get

## Solution
- This solution involves a recursive call and an additional function
- First we set up our main function
  * Assign str1 to a variable called **longerStr**, and str2 to a variable called **shorterStr**. This is for ease of understanding.
  * We need to check which string is longer. If str2 (shorterStr) is longer, return the function and reorder the words so that str2 is in str1's spot. This will make more sense later. 
  * If longerStr does not start with shorterStr, it means they are completely different words. Return an empty string
  * If shorterStr is empty, then return longerStr. There is nothing to compare if there is only one string.
  * If nothing fits those cases, then return the function call again, this time with the shorterStr in str1's place, and our additional function _shrinkLonger(longerStr,shorterStr)_ in the str2's place.
 
- _shrinkLonger()_ has two purposes: To find our GCD, and, once it has found it, to whittle down the other word to nothing so that our "shorterStr.isEmpty()" condition activates
  * We accomplish this by using a while loop.
  * While longerStr still starts with shorterStr, we shorten longerStr by reassigning it to be its own substring that starts at the index of shorterString's length. i.e: if longerStr = ABABAB and shorterStr = ABAB, ABABAB's substring would be AB, because ABAB is 4 characters long. (Remember all indexes start at 0)
  * We return longerStr
 
  -With these two functions, we should be able to find the GCD


## Why does this work?
We are looking for the longest prefix that goes into both str1 and str2 on the assumption that the longer of the two strings is divisible by the shorter of the two strings. We always want to operate on the longer string, since the shorter string will always contain our GCD and the longer string will be divisible by it.

We look for prefixes for that same reason; since one word is divisible by the other, then they both contain the same prefixes. We want to find the largest shared prefix, so we constantly check to see if the longer string starts with the same letters as the shorter string.

The substring logic in _shrinkLonger()_ works to either isolate a prefix or to reduce the remaining word to nothing. If the shorter string is not a prefix by itself, the loop within _shrinkLonger()_ will end up isolating the prefix for us. The prefix then becomes our shorter string, which, of course, divides equally into the larger string. What we are doing in practice is calling a sort of _modulo_ function on the longer string. We are finding out how many times the shorter string can divide it, and returning the remainder of the string if there is any.

## Time complexity
The time complexity of this algorithm depends on how many times the fucnction is recursively called.

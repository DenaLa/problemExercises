# Greatest Common Divisor of Strings

## Concepts
Math, Strings

## Instructions
For two strings **s** and **t**, we say _"t divides s"_ if and only if _s = t + ... + t_ (i.e., t is concatenated with itself one or more times).

Given two strings **str1** and **str2**, return the largest string **x** such that **x** divides both **str1** and **str2**.

## Given Hints
- The greatest common divisor must be a prefix of each string, so we can try all prefixes.

## Intuition
- Like the Hint says, we can assume the GCD has to be a prefix of each string. If the strings don't even share a prefix, then neither can be devisible by the other.
- When we consider divisibility, we always want to check if the larger string can be divided by the smaller one. When we are evaluating the strings, we will be deriving prefixes from them that are not necessarily the original string tat we are given. Knowing this, in the context of our method, we want to ensure that **str1** is longer than **str2**, so that we can always work on the assumption that our current **str1** is the one we are dividing into.
- _s = t + ... + t_. This means, that **s** consist of **t.** Meaning, **s** should be **t** repeated.
  * For example, if our **t** is _ABC,_ then it stands to say that **s** could look like _ABCABCABC,_ _ABCABC_, _ABCABCABCABC,_ etc.
- For the sake of this problem, if one of the strings is empty, then the prefix will be assigned to the string that is not empty.
- We will be using recurssion as a part of the solution. The recurssive statements will be explained after the step by step explanations.

## Step By Step Solution
1. We need two methods: our _gcdOfStrings()_ method and our _modulo()_ method. Both methods take two strings. _gcdOfStrings()_ has parameterof **str1** and **str2.** _modulo()_ has the parameters of **longer** and **shorter**
2. We will create our _modulo()_ method first.
   1. We want _modulo()_ to return our **longest** string.
   2. Create a while loop. This while loop will continue to run as long as the condition (**longer.startsWith(shorter)**) remains true.
   3. Inside the while loop, we modify **longer**. We want to update **longer** so that it is a substring that begins at **shorter.length()**
   4. If we do this, after a while, we should be able to find our shared prefix.
3. Now we will work on our _gcdOfStrings()_ method
   1. If **str1** is longer than **str2,** then we should make a recursive call to _gcdOfStrings()_ and reverse the placements of **str1** and **str2**
   2. If **str1** does not begin with **str2,** then return ""
   3. If **str2** is empty, then return **str1.**
   4. In the case that none of these conditions are met, we want to make a recurssive call to _gcdOfStrings()_. Our first parameter will be **str2,** and our second will be _modulo(str1, str2)_
4. That concludes all we need to do to solve this problem.

## Explaining the Solution
- Let's go through the logic of the modulo method
  * We are borrowing a concept from math, with _division_ and _modulo._ The _modulo_ operator returns the remainder of any two numbers you are trying to divide. For this problem, we also want to find the remainder of our longer string after we divide it with our shorter string. This is us finding the _prefix._ There are two cases that can happen while finding this prefix:
    1. Our **str2** divides perfectly into **str1**, leaving no prefix to speak of. This means that **str2** _is_ the prefix. _modulo()_ will return an empty string, and our condition of if _(str2.isEmpty()) {return str1}_ will be met. (Remember, when we recursively call _gcdOfStrings()_, **str2** always is put in the place of **str1**)
    2. Our **str2** does not divide perfectly into **str1**, and there is a remainder. That remainder serves as our new shorter string, and our new assumed _prefix._ The values inside our _gcdOfStrings()_ method now consist of our previous **str2** (Which was our shorter string) to now be **str1**, and the result of our _modulo()_ becomes **str2** (our shorter string). In this case, things will reat until the first condition is met.

## Code
```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Str1 Should be longer than Str2

        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }


        if (!str1.startsWith(str2)) {
            return "";
        }

        if (str2.isEmpty()) {
            return str1;
        }

        return gcdOfStrings(str2, modulo(str1, str2));
    }

    public String modulo(String longer, String shorter) {
        while (longer.startsWith(shorter)) {
            longer = longer.substring(shorter.length());
        }
        return longer;
    }

}
```


## Time Complexity
The time complexity depends on how many times _gcdOfStrings()_ is called

# Product of an Array Except Self
## Concepts Explored
_Arrays, Prefix Sum_

## Instructions
Given an array **nums**, return an array **ans** such that **ans[i]** is equal to the products of every element in the array except for itself. You cannot use division, and the runtime must be _O(n)_

### Guidance
We would need to find a way to isolate products from before our index and from after our index, and then multiply those two together.

## Solution
1. We will borrow the concepts of having a prefix array and a suffix array, but instead will work in a single array (**ans**)
   * The prefix array would handle the products of every element up until the current index. The suffix array would handle the products of every element in the array after the given index. And when you multiply these two arrays together, you will get a product that excludes the element at a given index.
2. To imitate this, we need to make an array **ans** that is the same length of **nums.** For convenience, we will also store the length in an int variable **n**
3. We set the first element of **ans** to 1 in order to utilize the Identity Property of Multiplication. We want it to be 1 instead of 0 because anything multiplied by 0 is 0, which will lead to an incorrect answer if 0 wasn't already a product of the original number.
4. We use a for loop, with out iterator starting at 1.
   * While we are in our for loop, **ans[I]** will equal to **ans[I-1] * nums[I-1]**. **nums** is our original array, and has all the numbers we want to work with. We are currently working on the **prefix** part of our final array, meaning we want to get the products of every element _before_ **ans[I]**. This is why we multiply the elements at **I-1,** we want to exclude the element at **I** from our calculations
5. When we are finished with the prefix part, we now have to set up the suffix part of the array.
   * set up an int **suffix** variable that equals 1. This is, again, to take advantage of the Identity Property of Multiplication
   * This time, we start at the end of the array. We want to get the products of every element _after_ **I**
   * For every loop, multiply **ans[I]** by the **suffix.** After you do that, multiply the **suffix** by **nums[I]**. Doing it in this order ensures that the **suffix** is always a product of the elements that come after **ans[I]**.
   * Since **ans** holds our prefix values, multiplying like this ends up being **prefix * suffix**, excluding the current value.
6. After that, return **ans**

## Why does this work?
As stated before, we are bringing the logic of having a prefix array and a suffix array and directly editing our answer array. The prefix array gets the products of every element from before the element at **I**, the suffix array gets everything from after the element at **I**. When you multiply those products together, you end up multiplying the products from everything _before_ **I** and everything _after_ **I**, but exclude **I** itself.

By doing this without using division, we can avoid awkward scenarios where 0 is included in the list of multipliers.

## Time complexity
The time complexity of this algorithm is _O(2n)_ for going through the loop twice, but _O(n)_ in equivalency.

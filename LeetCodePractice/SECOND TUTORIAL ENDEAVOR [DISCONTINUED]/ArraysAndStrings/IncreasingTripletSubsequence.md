# Increasing Triplet Subsequence

## Concepts
Array, Greedy

## Instructions
Given an integer array ```nums```, return ```true``` if there exists a triple of indices ```(i, j, k)``` such that ```i < j < k``` and ```nums[i] < nums[j] < nums[k]```. If no such indices exists, return false.

## Given Hints
N/A

## Intuition
- We want to find an increasing triplet, which means that we want to find three consecutive number that are in numerical order
- We can achieve this by first finding the first _two_ numbers that are in numerical order. For an increasing subsequence, we need to find two consecutive numbers, and see if the third one is larger than both numbers we have recorded.

## Step By Step Solution
1. We want a subsequence of A < B < C. Create two integers, ```A``` and ```B```. Give them the value of ```Integer.MAX_VALUE```. Do this to ensure we can catch any possible number in our array
2. Create a for each loop. We will loop on the conition ```int C : nums```
3. While we are inside our for each loop, we will check several things
   1. First, we check ```C <= A```. If it is, we set ```A``` to ```C```. We check this first to get the starting point of out subsequence.
   2. Next, we check ```C <= B```. To reach this condition, ```C``` would have to be greater than ```A```, but not ```B```. If the condition is fulfilled, then we set ```B``` to ```C```
   3. Lastly, we end with an else statement, that returns ```true```. The assumption is that if ```C``` isn't less than ```A```, and it isn't less than ```B```, that means it's greater than both of them, and we've found our subsequence.
4. Outside of our for loop, return ```false```. If the conditions in the for loop hasn't been fulfilled, that means there is no subsequence.

## Explaining the Solution
- We use if, if else, and else statements to ensure that we only cross what we need to when we want to cross it. ```C``` will always check itself against ```A``` first, even if there is a new value in ```B```. The ensures that if there is a number smaller than the current ```A```, it gets recorded and the starting index of our subsequence is adjusted.

## Code
```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int A = Integer.MAX_VALUE;
        int B = Integer.MAX_VALUE;

        for (int C : nums) {
            if (C <= A) {
                A = C;
            } else if (C <= B) {
                B = C;
            } else { // C > A, C > B, C > B > A
                return true;
            }

        }

        return false;
    }
}
```

## Time Complexity
O(n)

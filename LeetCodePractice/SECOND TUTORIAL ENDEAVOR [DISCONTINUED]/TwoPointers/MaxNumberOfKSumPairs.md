# Max Number of K-Sum Pairs

## Concepts
Array, Hash Table, Two Pointer, Sorting

## Instructions
You are given an integer array ```nums``` and an integer ```k```.

In one operation, you can pick two numbers from the array whose sum equals ```k``` and remove them from the array.

Return the maximum number of operations you can perform on the array.

## Given Hints
- The abstract problem asks to count the number of disjoint pairs with a given sum ```k```.
- For each possible value x, it can be paired up with ```k - x```.
- The number of such pairs equals to ```min(count(x), count(k-x))```, unless that ```x = k / 2```, where the number of such pairs will be ```floor(count(x) / 2)```.

## Intuition
- We are looking for pairs of numbers that can add up to ```k```. We can make the pairs where the number is the _smallest possible number + the largest possible number_ for every given sum.
- We don't need to retain the array order at all, so we can sort it in a way that makes looking for pairs in the way we want easier for us.
- We need a way to also deal with our sum being too large or too small.

## Step By Step Solution
1. Sort ```nums```.
2. Create several int variables, ```A``` that points at the beginning of the array, ```B``` that points at the end of the arra, and ```count``` that is equals to 0.
3. Create a while loop that runs on the logic ```A < B```
   1. Make an int ```sum```, which is ```nums[A] + nums[B]```
   2. if ```sum == k```, then we incrememnt ```count``` by 1, move ```A``` one space forward and move ```B``` one space back.
   3. If ```sum < k```, it means one of our numbers is too small. Our beginning pointer is to blame, so incrememnt ```A``` by 1 in order to find a bigger number
   4. If ```sum > k```, it means one of our numbers is too big. Our end pointer is to blame, so reduce ```B``` by 1 in order to find a smaller number.
4. At the very end, return count.

## Explaining the Solution
- We sort ```nums``` in order to assist in our logic. While we get rid of the _smallest possible number in k + largest possible number in k_, we move on to the _second largest + second smallest_, _third largest + third smallest,_ and so on.

## Code
```java
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int A = 0, B = nums.length - 1, count = 0;

        while (A < B) {
            int sum = nums[A] + nums[B];

            if (sum == k) {
                count++;
                A++;
                B--;
            } else if (sum < k) {
                A++;
            } else { // sum > k
                B--;
            }
        }
        return count;
    }
}
```

## Time Complexity
O(n)

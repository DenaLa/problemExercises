# Product of Array Except Self

## Concepts
Array, Prefix Sum

## Instructions
Given an integer array ```nums```, return an array ```answer``` such that ```answer[i]``` is equal to the product of all the elements of ```nums``` except ```nums[i]```.

The product of any ```prefix``` or ```suffix``` of nums is guaranteed to fit in a _32-bit integer_.

_**You must write an algorithm that runs in O(n) time and without using the division operation.**_

## Given Hints
N/A

## Intuition
- If we want to exclude the element at ```nums[i]```, it means that we want to multiply all the elements before ```nums[i]``` and after ```nums[i]```
- We can use two seperate arrays to do this

## Step By Step Solution
1. Create an int variable ```n``` to hold the length of ```nums```
2. Create two arrays, ```ans``` and ```suff```. ```ans``` will serve as both our answer array and our prefix array
3. Set ```ans[0]``` and ```suff[n-1]``` to 1. This is so our final product isn't 0.
4. Create a for loop to populate ```ans```. Our increment starts at ```1``` instead of ```0```
   * While the loop iterates, we set ```ans[i]``` to ```ans[i-1] * nums[i-1]```. Doing it this way excludes ```num[i]```
5. Create another for loop, this time for our suffix array. Our increment starts at ```n-2```, and instead of ```i++``` we use ```i--```
   * While the loop iterates, we set ```suff[i]``` to ```suff[i+1] * nums[i+1]```. We use addition since we are going backwards through the array.
6. We make one final loop, going through ```ans```. At each step, we set ```ans[i]``` to ```ans[i] * suff[i]```
7. Return ```ans```

## Explaining the Solution
- Our first for loop gets the prefix products for ```nums```. Our second for loop gets our suffix products. When we multiply them together, the resulting ```ans[i]``` will be the products of all numbers except those at ```nums[i]```

## Code
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] suff = new int[n];

        ans[0] = 1;
        suff[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i > -1; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] *= suff[i];
        }

        return ans;
    }
}
```

## Time Complexity
O(n)

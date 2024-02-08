# Kids With the Greatest Number of Candies

## Concepts
Array

## Instructions
There are **n** kids with candies. You are given an integer array **candies**, where each **candies[i]** represents the number of candies the _ith_ kid has, and an integer **extraCandies**, denoting the number of extra candies that you have.

Return a boolean array result of length **n**, where **result[i]** is _true_ if, after giving the _ith_ kid all the **extraCandies**, they will have the greatest number of candies among all the kids, or _false_ otherwise.

Note that multiple kids can have the greatest number of candies.

## Given Hints
- Use greedy approach. For each kid check if candies[i] + extraCandies ≥ maximum in Candies[i].

## Intuition
- We are picking out the largest number in the array and comparing it to the current number in the array + extraCandies
- Like in real life, we find the number first, then start comparing other numbers against it.


## Step By Step Solution
1. Since the return type of our method is _List<Boolean>,_ we create _List<Boolean>_ named ans. We initialized it as an _ArrayList_
2. Create an int variable **max**, and set it to 0
3. Make a for each loop, with the parameters _for(int a : candies)._ While in this loop, we test to see if **a** is greater than **max**, and if it is, we set **max** to **a**
4. Make another for each loop, with the same parameters as the last. We are still comparing values, but we will do it in a bit of a different way. While the loop iterates, we will add the value of _(a+extraCandies) >= max_ to **ans.** This expression will return either _true_ or _false,_ populating our array.
5. At the end, return **ans**

## Explaining the Solution
- We could theoretically replace our first for each loop with the statement ```int max = Arrays.stream(candies).max().getAsInt()```. While this works, it is just a little bit slower for our small scale, so we choose the simpler option.
- Likewise, within our first for each loop, we could replace ```if (a > max) {max = a;} ``` with ```max = Math.max(max, a);```, but the former takes up a little less space than the latter

## Code
```java
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = 0;
        for (int a : candies) {
            if (a > max) {
                max = a;
            }
        }

        for (int a : candies) {
            ans.add((a + extraCandies) >= max);
        }

        return ans;
    }
}
```

## Time Complexity
O(n)

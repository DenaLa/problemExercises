# Kids With the Greatest Number of Candies
## Concepts Explored
_Arrays, Greedy Algorithm_

## Instructions
There are **n** kids with candy. You are given an int array **candies**, where **candy[i]** denotes the amount of candy one kid has, and an int **extraCandies**,  which determines how much candy _you_ have to give.

Return a boolean ArrayList where **result[i]** is true if the kid you gave candy to would have the greatest amount of candy out of all the other kids. If they wouldn't, then **result[i]** is false instead.

### Guidance
More than one child can have the greatest amount of candies if you give them candy. For each child, check to see if **result[i]** + **extraCandies** would be a greater amount than what the current greatest amount is.

## Solution
1. Create a Boolean ArrayList to hold our answers in (**ans**)
2. Use Java8's stream functions to get the largest number in **candies** and put it into its own variable (**mostCandy**)
   * Arrays.stream(candies).max().getAsInt()
3. Create a for loop that will go through each element of candies. While we do this, we test to see if **candies[i]** + **mostCandy** would be greater than **mostCandy**. We then add the result of that test to **ans**
4. At the end, return **ans**

## Why does this work?
We want to know if the current child will have the most candy out of everyone once we give them extra. Instead of testing against every child, we only need to test against the child that currently has the most amount of candy

## Time complexity
The time complexity of this algorithm is _O(n)_ because we need to go through the whole array to complete our objective.

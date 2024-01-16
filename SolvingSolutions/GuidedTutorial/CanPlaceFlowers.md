# Can Place Flowers
## Concepts Explored
_Arrays, Greedy Algorithm_

## Instructions
You have a long flowerbed with some floweres planted in some of the plots. You don't want to plant any flowers in adjacent plots though.

Given an int array **flowerbed** filled with 0s (empty plot) and 1s (planted plot), and an int **n** that represents the amount of flowers you want to plant, return true or false depending on whether or not you can successfully plant all **n** flowers in the flowerbed

### Guidance
Think about the conditions that a flowerbed can be planted. What circumstances for each position can a flower be planted?

## Solution
1. First, if **n** is 0, return true. That means there are no flowers we want to plant
2. Now we check for three cases to all be true at once:
   * Is **flowerbed[i]** empty?
   * Is **i** at the start of our array OR is **flowerbed[i-i]** empty?
   * Is **i** at the end of the array OR is **flowerbed[i+1]** empty?
3. if all these conditions are true, plant a flower at **flowerbed[i]** by decreasing it, and decrease **n** by 1.
4. If at any point during this loop, **n** falls all the way to zero, it means that we have successfully planted all flowers, and that it is possible to plant **n** flowers in our flowerbed
5. However, if we leave the loop and **n** is still above 0, it means we didn't get to plant all our flowers, and that our problem is false.

## Why does this work?
We check to see if our current position is empty first, because if it isn't even if the adjacent spaces were empty, we can't plant another flower on top of it.

The we separate the conditions of _first plot being empty and the field after it is empty_ and _the last plot is empty and the plot behind it is empty_ because if we paired them together, then our loop would only account for those conditions, and not the conditions where plots in the middle can be empty. With the way we write the conditions in our algorithm, we can account for plots in the middle of the array being viable.

## Time complexity
The time complexity of this algorithm is _O(n)_ because it is possible we'll travel through the array start to finish before finishing the objective.

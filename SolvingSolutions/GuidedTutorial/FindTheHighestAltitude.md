# Find The Highest Altitude
## Concepts Explored
_Arrays, Prefix Sum_

## Instructions
There is a biker going on a road trip. The road trip consists of **n + 1** points at different altitudes. The biker starts his trip on point **0** with altitude equal **0**.

You are given an integer array **gain** of length **n** where **gain[i]** is the net gain in altitude between points **i**​​​​​​ and **i + 1** for all **(0 <= i < n)**. Return the highest altitude of a point.

### Guidance
- The altitude at any given point is the total net gain of all the points behind it
- This means, for any point in **altitude[i]** it is the sum of **altitude[i-1]** and all values of **gain** up until **i-1**

## Solution
1. The biker stops at **n+1** stops, so we create a new array called **alt** that is of length **n+1**
2. We also create a variable **max** to keep track of our max altitude. This starts at 0.
3. Set **alt[0]** to **0,** since the biker always starts at a an altitude of 0.
4. We will iterate through **alt** in order to populate it. While we are doing so, we do the following:
   * **alt[i]** will be the sum of **alt[i-1]** and **gain[i-1]**
   * We compare our current **max** to **alt[i]**, and set **max** to whichever number is higher.
5. At the end, return **max** 

## Why does this work?
**alt[i]** is always going to be the sum of **alt[i-1]** and **gain[0] + ..... gain[i-1]**. We can compare **max** to the current **alt[i]** as we calculate, instead of needing to do a second run through the loop.

## Time complexity
The time complexity of this algorithm is _O(n)_. We need to iterate through the entire array in order to complete our objective.

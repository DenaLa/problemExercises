# Maximum Average Subarray I
## Concepts Explored
_Arrays, Sliding Window_

## Instructions
You have an int array **nums** of size **n**, and an integer **k.** Find a contiguous subarray of length **k** that has a maximum average value, and then return that same average.

### Guidance
We can use a sliding window technique here. How can we look at a range of elements, and how can we slide the window over?

## Solution
1. We want to return the average, but we can just calculate it as we return. Instead, we are going to make variables to keep track of the various sums that we need.
   * Create a double variable **sum** to keep track of our current sum
   * Create a double variable **maxSum** to keep track of the highest sum that we encounter
2. We want to calculate the sum of values from **nums[0]** to **nums[k]** at first. This gives us our baseline sum to compare other sums to. Iterate through the array up to element **k-1** and add the values to our sum.
3. Set **maxSum** to our sum
4. We are now going to iterate trough **nums** again, this time starting at **k**. We do this to achieve our sliding window view
   * Add the **nums[k]** element to sum, while subtracting the **nums[i-k]** element.
   * Compare the values of **sum** and **maxSum.** Whichever one is higher will become the new **maxSum.**
5. At the end of it all, we will have our proper **maxSum**. Return **maxSum/k** to get the highest average.

## Why does this work?
The method we use to calculate our sum is callsed a **Sliding Window.** We keep a frame (in this case, of range **k**) over our array, slowly sliding it over to see if we can get a better average with different sets of numbers. This is why we calculate the sum of the first **k** elements at first, and then started at index **k** when we wanted to continue. Imagine our range of **k** to be a physical object. When we start at the beginning, it takes up the values of **nums[0]** to **nums[k-1]**. When we begin sliding it over, it will then take the values of **nums[1]** to **nums[k]**, and so on, up until **nums[nums.length-1]**. 

The reason why we start at **k** the second time around is because that is the end of our window after we calculate the first sum. We add **nums[i]** and subtract **nums[i-k]** because we want to slide the window by _adding_ our new element, and _subtracting_ the element no longer in range. (**i=k** at the start, but will become larger with iterations, which is why we subtract **k** from it instead of te other way around. The reason why we subtract **k** to begin with is because **k** happens to be the range of our window.)

## Time complexity
The time complexity of this algorithm is _O(n)_. We need to traverse the entire loop in order to complete our objective.

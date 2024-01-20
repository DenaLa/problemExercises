# 
## Concepts Explored
_Arrays, Hash Tables, Matrix, Simulation_

## Instructions
Given a _0-indexed_ **n x n** integer matrix **grid**, return the number of pairs _(ri, cj)_ such that row **ri** and column **cj** are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

### Guidance
- You can use nested loops to compare every row against every column
- Another loop is necessary to compare the row and column element by element.
- It is also possible to hash the arrays and compare the hashed values instead.

## Solution
1. Create a variable to store the length of the grid. This will help us with ease of coding.
2. Create a variable to store the answer. Initialize it at 0.
3. We are going to go through the grid in this order:
   * First, we will settle on a row. This is tracked with **i.**
   * Then, we will compare every column to that row. This is tracked with **j.**
   * We will compare the elements of each row to the elements in each column. For this, we will utilize **k**
   * If at any point, the element of a row and an element of a column don't match, exit the column and start comparing the next one.
4. We will be using three for loops to accomplish this task.
   * A thing to note is _when_ each component moves
   * **i**, which is tracking our rows, only moves after we've compared it to each column. It is our outermost for loop.
   * **j**, which is tracking our columns, only moves after we find an element in our row that doesn't match an element in our column.
   * **k** is reset every time we move to a new column. This is so we can start element comparisons at the front of the respective row and column.
   * If **k** at any point equals **length**, increment **answer** by 1.
5. Once we are finished going through the entire grid, return **answer.**


## Why does this work?
We are systematically going through each row, each column, and each element to compare. We take advantage of the fact that the grid is a square with the same length and width. Intuitively, we are comparing things row wise. You select the row you want to compare, and then look at the column. You look at each matching element to see if they match. If they do match, you found a pair. If they don't, you move onto the next column and try again.

## Time complexity
The time complexity of this algorithm is _O(n<sup>3</sup>)_. We nest three loops in order to complete our objective.

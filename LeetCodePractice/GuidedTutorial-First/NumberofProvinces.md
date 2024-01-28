# Number of Provinces

## Concepts Explored
_DFS, BFS, Union Search, Graph_

## Instructions
There are **n** cities. Some of them are connected, while some are not. If city **a** is connected directly with city **b**, and city **b** is connected directly with city **c**, then city **a** is connected indirectly with city **c**.

A _province_ is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an _n x n matrix_ **isConnected** where **isConnected[i][j] = 1** if the _ith_ city and the _jth_ city are directly connected, and **isConnected[i][j] = 0** otherwise.

Return the total number of provinces.

### Guidance
N/A

## Solution
1. Create a variable **ans** with a value of 0, and a boolean array **visited** that is as long as **isConnected**
2. We need to create a custom _dfs_ method. We call this when visiting a new node on our graph (or, viiting a new city). It's parameters are our matrix, our boolean array, and an int that keeps track of what row in our matrix we are on
   * When we first enter _dfs,_ set **visited[i]** to true. This represents us visiting our respective city
   * create a for loop. This for loop will be led by an int **j**, and will loop for the length of **isConnected**. While we are looping, we check to see if **isConnected[i][j]** is 1, and if **visited[i]** is true. **isConnected[i][j]** being 1 means that current city is connected through there. **visited[i]** means that we have visited this city in our matrix to mark it as connected. They both need to be true, to prevent situations where we have a 1 in a city, only for it to be a city we have previously visited before and counting it twice.
     * If the condition is met, then we call _dfs_ again with new parameters: **isConnected** and **visited** and **j**
  * That is it for _dfs_
3. Back in our main method, we create a for loop that is dependent on **i** being less than the length of **isCOnnected**
4. Inside this loop, we check to see if **visited[i]** is false. If it is, we increment **ans** byy 1, and call _dfs_ with the parameters **isConnected,** **visited**, and **i**
5. At the end of everything, return **ans**


## Why does this work?
- The way the cities are arranged in the matrix is that there will be a 1 for one of two conditions: The city is located there, or the city is connected to the city located there. So, for example, City 1 having a value of 110 means that is exist, and is connected to City 2. Likewise, if City 1 had a value of 101, it would mean that it it is located where it is, and also connected to City 3.
- As explained before, when we are checking for cities in _dfs,_ we check to see a city's connection _and_ to see whether we've visited a particular city already to prevent us from visiting it twice.


## Time complexity
The time complexity of this algorithm is _O(n<sup>2</sup>)_. We are working through a matrix, and are comparing elements from the rows against elements in the columns.

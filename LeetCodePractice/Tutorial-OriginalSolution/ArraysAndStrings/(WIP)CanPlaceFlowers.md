# Can Place Flowers

## Concepts
Array, Greedy

## Instructions
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in _adjacent_ plots.

Given an integer array ```flowerbed``` containing ```0```'s and ```1```'s, where ```0``` means empty and ```1``` means not empty, and an integer ```n```, return ```true``` if ```n``` new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and ```false``` otherwise.

## Given Hints
N/A

## Intuition
- There are three general places that we could plant a flower: At the beginning, at the end, and anywhere in between. To plant a flower in general, the space needs to be empty.
  * If we want to plant a flower in the beginning, we need to check is the space after it is empty
  * If we want to plant a flower at the end, we need to check if the space before it is empty
  * If we want to plant a flower in between, we have to check if the two adjacent spaces are empty
- While we check to see if we can plant extra flowers, we need to keep track of how many we've already planeted. We also need to actually plant the flowers to determine if it's possible to fit ```n``` amount of flowers in our flowerbed.

## Step By Step Solution
1. Create an integer variable ```len``` to hold the length of ```flowerbed```
2. If ```n``` is 0, return ```true```. There are no flowers to plant
3. We need to create a for loop. This for loop will iterate for the entire flowerbed
4. Inside the for loop, we check for three conditions, each seperated by the ```&&``` operator
   1. Is ```flowerbed[i]``` 0?
   2. Is ```i``` 0 or ```flowerbed[i-1]``` 0?
   3. Is ```i``` equals to ```len-1``` or ```flowerbed[i+1]``` 0?
   * If these conditions are met, then we make ```flowerbed[i] = 1``` and reduce ```n``` by ```1```.
   * If at any point ```n == 0```, we return ```true```
5. Outside our for loop, we return ```false```. It means that ```n``` never reached 0, which in turn means we did not plant all of our flowers.

## Explaining the Solution
- The way the logic is coded seems a bit strange. While it does make sense to check ```flowerbed[i] == 0```, the way our three conditions are checked may seem odd.
  1. ```(i == 0 || flowerbed[i - 1] == 0)``` Serves to check whether or not our index is at the very start of the flowerbed. Neither of these statements can be true at the same time; if ```i == 0```, there is no ```i-1``` to check, and if there is an ```i-1``` to check, then ```i``` isn't 0. It is done this way to prevent the algorithm from checking for a previous index while we are at the beginning
  2. Likewise, ```(i == len - 1 || flowerbed[i + 1] == 0)``` accomplishes this except for the end of the array instead.

## Code
```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;

    }
}
```


## Time Complexity
O(n)

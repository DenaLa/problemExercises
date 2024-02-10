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
3. We need to create a for loop.

## Explaining the Solution


## Code
```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < len; i++) {
            if ((i == 0 || flowerbed[i - 1] == 0) && flowerbed[i] == 0 && (i == len - 1 || flowerbed[i + 1] == 0)) {
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

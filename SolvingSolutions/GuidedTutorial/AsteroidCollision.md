# Asteroid Collision
## Concepts Explored
_Arrays, Stacks, Simulations_

## Instructions
We are given an array **asteroids** of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

### Guidance
- We can push and pop asteroids on and off a stack based on the direction and size of them all
- Just because an incoming asteroid destroys one on the top of the stack, doesn't mean it'll destroy all the asteroids in a stack
- Remember that we can travel backwards through an array

## Solution
1. Create an integer **peek**. We will use this variable to keep track of the top of our stack
2. Create a stack **st.** We will use it to simulate the asteroids problem
3. We will iterate through **asteroids** with a ForEach loop. While we do this, we will do the following:
   * If **st** is empty, or our current element is greater than 1, push it onto the stack. If it is empty it means that there are no asteroids in line yet. If it is greater than 1, it means that it is going right, like our other assumed asteroid.
   * If neither of these are true, then we check another case.
   * We encapsulate the following in an _else_ statement
     * Set it so that everything is encapsulated in a while loop, where the condition is _while(true)_. We will be escaping this loop by using the _break_ keyword.
     * Set **peek** to the top value of the stack by using the _peek_ method
     * If **peek** is less than zero, we push the current element onto the stack. **peek** being less than zero means it is going left, and we are only in this else statement because the incoming asteroid is also going left. (Meaning, it's a negative number.) _break_ out of the loop.
     * If **peek** has the same absolute value as the incoming asteroid, but is positive, it means the two will collide and destroy each other. We check this by seeing if **peek** is the same value as **-a**. _break_ out of the loop
     * If **peek** has a bigger absolute value of the incoming asteroid, then it will just destroy it. Check this the same way we checked the previous sondition, and _break_ out of the loop.
     * Lastly, if the incoming asteroid has a greater absolute value than **peek,** then **peek** gets destroyed. We pop the value off of **st**, but we _don't_ break or add the new asteroid yet. Instead, we check additionally to see if **st** is empty. If it is, add the current asteroid and _break_ out of the while loop.
     * This while loop will ensure that any incoming asteroids that are heading in the opposite direction of the present asteroids will destroy what they can, and be destroyed by what they can't.
4. At the end, create an array **ans** that is as big as **st**
5. Populate **ans** backwards while popping elements off of **st**
6. Return **ans**


## Why does this work?
Our first if statements accounts for two things: the stack being empty and the stack _not_ being empty, but the incoming asteroid is traveling in the same direction.

Our else statement + while loop accounts for the other situations
- If there is an asteroid heading left already in the stack, then another asteroid heading left will just cruise along with it. That is our first if statement
- If there is an asteroid of the same size heading towards the incoming asteroid, then they both end up destroyed. This is our first else if statement
- If the incoming asteroid is smaller than our current asteroid, the incoming asteroid gets destroyed. This is our second else if statement
- If our incoming asteroid is larger than our current asteroid, then it destroys. We don't break out of the loop at this point, because we need to test this incoming asteroid against the rest of the asteroids currently on the stack. If there are no asteroids, we can safely add it to the stack, and break out of the loop in order to test the next asteroid.

## Time complexity
The time complexity of this algorithm is _O(n)_. We need loop arond several times to complete our objective, but we do not nest loops in a way that makes it so that we test every element of one loop against another.

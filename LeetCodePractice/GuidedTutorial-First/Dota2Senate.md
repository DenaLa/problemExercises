# Dota2 Senate
## Concepts Explored
_Design, Queue, Data Stream_

## Instructions
In the world of Dota2, there are two parties: the _Radiant_ and the _Dire_.

The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:

  - Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
  - Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.

Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.

The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.

Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".

### Guidance
- We will consider the senate members going in order from 0 to the length of the string. So the person at index 0 goes before the person at index 1, and so forth
- The senate will always choose to eliminate a member of the opposing party on their turn. They will do this unless there is no one left
- When a senate member acts, they will immediately go to the back of the line. Their turn will be after everyone else that wa previously after them

## Solution
1. record the length of the **senate** array into a variable called **len**
2. Create two integer queues for the Radiant and Dire parties, **rad** and **dir**
3. Create a for loop. We are going to populate the respective queues with the index of the respective party members. The logic is, those earlier in the string get their turn before those later in the string.
   * Populate the queues accourding to what letter the current character of **senate** is
4. Now use a while loop that relies on both **rad** and **dir** not being empty
5. Compare the two frontmost elements of **rad** and **dir**. If the front of **rad** is lower than the front of **dir,** that senate member gets sent to the back of the line, so to speak. Add them to the back of the queue by incrementing the saved **len** value by one, and adding that integer to **rad**. If the front of **dir** is instead lower, add that element to **dir** instead.
6. Once you are done with the comparison, still inside the while loop, pop both front elements off of the queue. This represents the senate member using their turn, but only one of these senate members still has their right to vote. The senate member will be whoever was sent to the back during the check.
7. Once the while loop finishes, we will return this conditional operator: _(rad.isEmpty() ? ("Dire") : ("Radiant")_
   * the format of this operator is as followed: [expression] ? (value if expression is true) : (value if expression is false) 

## Why does this work?
As stated in the guidance, we know these three conditions:
1. The senate members are going in order of their index.
2. The senate member of one party will always aim to eliminate a senate member of another party
3. The senate member that has acted will have to wait for next round in order to act again.

But why don't the members of the opposing party revenge vote the last acting senator out? Because that senetor is no longer a problem for them, since they ned to wait for the next round. Instead, they will vote out a senator that still has a right to act by removing their rights and forcing them to withdraw.

This is why Dire can win in a case like "DDRRR". Despite being initially outnumbered, Dire gets to move first. They can immediately whittle down the Radiant party down to one senate member while both being safe, and even if that remaining member takes out one Dire member, the remaining Dire member simply votes them out.

## Time complexity
The time complexity of this algorithm is _O(n)_. We need to iterate through the entire array and two queues in order to complete our objective.

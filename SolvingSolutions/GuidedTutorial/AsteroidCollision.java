package asteroidCollision;

import java.util.Stack;

public class AsteroidCollision {

	public static void main(String[] args) {
		int[] asteroids1 = {5,10,-5};
		int[] asteroids2 = {8,-8};
		int[] asteroids3 = {10,2,-5};
		
		int[] ans1 = asteroidCollision(asteroids1);
		int[] ans2 = asteroidCollision(asteroids2);
		int[] ans3 = asteroidCollision(asteroids3);
		
		for(int a : ans1) {
			System.out.print(a + " ");
		}
		System.out.println();
		for(int a : ans2) {
			System.out.print(a + " ");
		}
		System.out.println(); 
		for(int a : ans3) {
			System.out.print(a + " ");
		}
		System.out.println();

	}
	
    public static int[] asteroidCollision(int[] asteroids) {
        int peek = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int a : asteroids) {
        	if(st.isEmpty() || a > 0){
        		st.push(a);
        	}
        	else {
        		while(true) {
        			peek = st.peek();
        			if(peek < 0) { //asteroid on top is heading in the same direction
        				st.push(a);
        				break;
        			}
        			else if(peek == -a) { //asteroid on top is heading towards incoming asteroid. They are the same size
        				st.pop();
        				break;
        			}
        			else if(peek > -a) { //asteroid on top is heading towards incoming asteroid. But it's bigger, so it destroys it.
        				break;
        			}
        			else{ //asteroid on top is heading towards incoming asteroid. It is smaller, and needs to get destroyed
        				st.pop();
        				if(st.isEmpty()) {
        					st.add(a);
        					break;
        				}
        				
        			}
        		}
        	}
        }
        	
        	
        	
        int ans[] = new int[st.size()];
    	
        for(int i = ans.length-1; i > -1; i--) {
        	ans[i] = st.pop();
        }
    	
    	return ans;
    }

}

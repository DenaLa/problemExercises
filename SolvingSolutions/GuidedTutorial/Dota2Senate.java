package dota2Senate;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    
	public static void main(String[] args) {
		String senate1 = "RD";
		String senate2 = "RDD";
		String senate3 = "DDRRR";
		
		System.out.println(predictPartyVictory(senate1));
		System.out.println(predictPartyVictory(senate2));
		System.out.println(predictPartyVictory(senate3));
		
	}
	
	
	
	public static String predictPartyVictory(String senate) {
		int len = senate.length();
		Queue<Integer> rad = new LinkedList<>();
		Queue<Integer> dir = new LinkedList<>();
		
		
		for(int i = 0; i < len; i++) {
			if(senate.charAt(i) == 'R'){
				rad.add(i);
			}
			else {
				dir.add(i);
			}
		}
		
		
		while(!rad.isEmpty() && !dir.isEmpty()) {
			if(rad.peek() < dir.peek()) {
				rad.add(len++);
			}
			else {
				dir.add(len++);
			}
			
			rad.poll();
			dir.poll();
			
		}

       return (rad.isEmpty() ? ("Dire") : ("Radiant"));
    }
}

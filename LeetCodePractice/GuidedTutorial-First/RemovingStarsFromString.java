package removingStarsFromString;

import java.util.Stack;

public class RemovingStarsFromString {

	public static void main(String[] args) {
		String s1= "leet**cod*e";
		String s2 = "erase*****";
		
		
		System.out.println("\"" + removeStarsA(s1) +"\"");
		System.out.println("\"" + removeStarsB(s2) +"\"");
		

	}
	
    public static String removeStarsA(String s) {
        if(s.isEmpty() || s.isBlank()) {
        	return "";
        }
    	
    	StringBuilder sb = new StringBuilder();
    	Stack<Character> st = new Stack<>();
    	
    	for(char c : s.toCharArray()) {
    		if(c != '*') {
    			st.push(c);
    		}
    		else{
    			if(!st.isEmpty()) {
    				st.pop();
    			}
    		}
    	}
    	
    	if(st.isEmpty()) {
    		return "";
    	}
    	while(!st.isEmpty()) {
    		sb.append(st.pop());
    	}

    	return sb.reverse().toString();
    }
    
    
    public static String removeStarsB(String s) {
        if(s.isEmpty() || s.isBlank()) {
        	return "";
        }
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(char c : s.toCharArray()) {
    		if(c != '*') {
    			sb.append(c);
    		}
    		else{
    			if(!sb.isEmpty()) {
    				sb.deleteCharAt(sb.length()-1);
    			}
    		}
    	}
    	

    	return sb.toString();
    }
}
	

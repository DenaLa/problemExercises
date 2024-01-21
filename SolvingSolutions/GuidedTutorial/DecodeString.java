package decodeString;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		String s1 = "3[a]2[bc]";
		String s2 = "3[a2[c]]";
		String s3 = "2[abc]3[cd]ef";
		
		
		String ans1 = decodeString(s1);
		String ans2 = decodeString(s2);
		String ans3 = decodeString(s3);
		
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);

	}
	
	public static String decodeString(String s) {
        Stack<Integer> repeats = new Stack<>();
        Stack<StringBuilder> str = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for(char c : s.toCharArray()) {
        	if(Character.isDigit(c)) {
        		count =  + (c - '0');
        	}
        	else if(c == '['){
        		repeats.push(count);
        		count = 0;
        		str.push(sb);
        		sb = new StringBuilder();
        	}
        	else if(c == ']') {
        		int k = repeats.pop();
        		StringBuilder temp = sb;
        		sb = str.pop();
        		while(k > 0) {
        			sb.append(temp);
        			k--;
        		}
        	}
        	else {
        		sb.append(c);
        	}
        }

		return sb.toString();
    }

}

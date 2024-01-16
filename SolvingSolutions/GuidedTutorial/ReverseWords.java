package reverseWords;

import java.util.ArrayList;

public class ReverseWords {
	public static void main (String[] args) {
		String s1 = "the sky is blue";
		String s2 = "  hello world  ";
		String s3 = "a good   example";
		
		System.out.println("\"" + reverseWords(s1) + "\"");
		System.out.println("\"" + reverseWords(s2) + "\"");
		System.out.println("\"" + reverseWords(s3) + "\"");
	}
	
	public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] A = s.split("\\s+");
        ArrayList<String> B = new ArrayList<>();
        
        for(int i = A.length-1; i > -1; i--) {
        	B.add(A[i]);
        }
        
        for(String a : B) {
        	sb.append(a).append(" ");
        }
		
		return sb.toString().trim();
    }
	
	
	
	
	
}

package isSubsequence;

public class IsSubsequence {
	public static void main(String args[]) {
		String s1 = "abc";
		String t1 = "ahbgdc";
		
		String s2 = "axc";
		String t2 = "ahbgdc";
		
		
		System.out.println(isSubsequence(s1,t1));
		System.out.println(isSubsequence(s2,t2));
		
		
	}
	
	public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) {
        	return true;
        }
        
        int A = 0;
        for(char c: t.toCharArray()) {
        	if(s.charAt(A) == c) {
        		A++;
        	}
        	if(A == s.length()) {
        		return true;
        	}
        }
        
        return false;
    }

}

package reverseVowels;

public class ReverseVowels {

	public static void main(String[] args) {
		String sA = "hello";
		String sB = "leetcode";
		
		System.out.println(reverseVowels(sA));
		System.out.println(reverseVowels(sB));

	}
	
	public static String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        String vowels = "aeiouAEIOU";
        int A = 0;
        int B = s.length()-1;
        
        while(A < B) {
        	while(A < B && (vowels.indexOf(sb.charAt(A)) == -1)) {
        		A++;
        	}
        	while(A < B && (vowels.indexOf(sb.charAt(B)) == -1)) {
        		B--;
        	}
        	sb.setCharAt(A, s.charAt(B));
        	sb.setCharAt(B, s.charAt(A));
        	A++;
        	B--;
        }
        
        
        return sb.toString();
    }
	


}

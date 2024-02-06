package maxVowleInSubstring;

public class MaxVowelInSubstring {

	public static void main(String[] args) {
		String s1 = "abciiidef";
		int k1 = 3;
		
		String s2 = "aeiou";
		int k2 = 2;
		
		String s3 = "leetcode";
		int k3 = 3;
		
		System.out.println(maxVowels(s1,k1));
		System.out.println(maxVowels(s2,k2));
		System.out.println(maxVowels(s3,k3));

	}

    public static int maxVowels(String s, int k) {
        int count = 0;
        int maxVowels = 0;
        for(int i = 0; i<k; i++) {
        	if(isVowel(s.charAt(i)) == true) {
        		count++;
        	}
        }
        
        maxVowels = count;
        for(int i = k; i < s.length(); i++) {
        	if(isVowel(s.charAt(i)) == true) {
        		count++;
        	}
        	if(isVowel(s.charAt(i-k)) == true) {
        		count--;
        	}
        	
        	maxVowels = Math.max(maxVowels, count);
        	
        }

        return maxVowels;
    }
    
    public static boolean isVowel(char c) {
    	if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
    		return true;
    	}
    	
    	return false;
    }
    
}

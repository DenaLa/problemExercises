package areTwoStringsClose;

import java.util.Arrays;

public class AreTwoStringsClose {

	public static void main(String[] args) {
		String word1 = "abc";
		String word2 = "bca";
		
		String word3 = "a";
		String word4 = "aa";
		
		String word5 = "cabbba";
		String word6 = "abbccc";

	}
	
	public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) {
        	return false;
        }
        if(word1.equals(word2)) {
        	return true;
        }
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        for(int i = 0; i < word1.length(); i++) {
        	freq1[word1.charAt(i) - 'a'] += 1;
        	freq2[word2.charAt(i) - 'a'] += 1;
        	
        }
        
        
        for(int i = 0; i< 26; i++) {
        	if((freq1[i] == 0 && freq2[i] != 0 ) || (freq1[i] != 0 && freq2[i] == 0)) {
        		return false;
        	}
        }
        
        
        Arrays.sort(freq1);
        Arrays.sort(freq2);

		return Arrays.equals(freq1, freq2);
    }

}

package mergeStringsAlternatively;

public class MergeStringsAlternatively {

	public static void main(String[] args) {
		String word1 = "abc";
		String word2 = "pqr";
		
		String word3 = "ab";
		String word4 = "pqrs";
		
		String word5 = "abcd";
		String word6 = "pq";
		
		
		System.out.println(mergeAlternatelyA(word1,word2));
		
		System.out.println(mergeAlternatelyB(word3,word4));
		
		System.out.println(mergeAlternatelyB(word5,word6));
		
		

	}
	
	public static String mergeAlternatelyA(String word1, String word2) {
        String merged = "";
		int shorter = Math.min(word1.length(), word2.length()); //records the length of the shorter string
		
		for(int i = 0; i < shorter; i++) {
			merged = merged + word1.charAt(i) + word2.charAt(i);
		}
        
		
		if(word1.length() > word2.length()) {
			merged =  merged + word1.substring(shorter,word1.length());
		}
		else {
			merged =  merged + word2.substring(shorter,word2.length());
		}

		
		return merged;
    }
	
	public static String mergeAlternatelyB(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
		int shorter = Math.min(word1.length(), word2.length()); //records the length of the shorter string
		
		for(int i = 0; i<shorter; i++) {
			merged.append(word1.charAt(i));
			merged.append(word2.charAt(i));
		}

		
		return merged.append(word1.substring(shorter)).append(word2.substring(shorter)).toString();
    }

}

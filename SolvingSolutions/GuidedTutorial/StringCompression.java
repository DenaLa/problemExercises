package stringCompression;

public class StringCompression {
	public static void main(String args[]) {
		char[] charsA = {'a','a','b','b','c','c','c'};
		char[] charsB = {'a'};
		char[] charsC = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		
		System.out.println(compress(charsA));
		System.out.println(compress(charsB));
		System.out.println(compress(charsC));
		
		
	}
	
	public static int compress(char[] chars) {
		int newLen = 0;
		
		for(int I = 0; I< chars.length;) {
			char check = chars[I];
			int count = 0;
			while(I<chars.length && chars[I] == check) {
				count++;
				I++;
			}
			chars[newLen] = check;
			newLen++;
			if(count > 1) {
				for(char c : String.valueOf(count).toCharArray()) {
					chars[newLen] = c;
					newLen++;
				}
			}
		}
		
		return newLen;
		
    }
}

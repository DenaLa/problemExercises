package gcdOfStrings;

public class GCDofStrings {

	public static void main(String[] args) {
		String str1 = "ABCABC";
		String str2 = "ABC";
		
		String str3 = "ABABAB";
		String str4 = "ABAB";
		
		String str5 = "LEET";
		String str6 = "CODE";
		
		System.out.println("\"" + gcdOfStrings(str1, str2) + "\"");
		System.out.println("\"" + gcdOfStrings(str3, str4) + "\"");
		System.out.println("\"" + gcdOfStrings(str5, str6) + "\"");

	}
	
	public static String gcdOfStrings(String str1, String str2) {
	    String longerStr = str1;
	    String shorterStr = str2;
		
		if (longerStr.length() < shorterStr.length()) { //str2 is longer, and we only want to shrink the longer strings
	    	return gcdOfStrings(shorterStr, longerStr);
	    }
	    if (!longerStr.startsWith(shorterStr)) { //since str1 is divisible by str2, if str1 doesn't start with str2, it means they're not divisible.
	    	return "";
	    }
	    if (shorterStr.isEmpty()) { //str 2 is empty, which means there is no GCD to be had. Just return str1
	    	return longerStr;
	    }
	    return gcdOfStrings(shorterStr, shrinkLonger(longerStr, shorterStr));
	  }

	  public static String shrinkLonger(String longerStr, String shorterStr) {
		  //This function will shrink the longer string down.
		  //We do this to both strings. Eventually, it produces our prefix
		  //When we get this prefix, the algorithm will make s1 completely empty
		  //this will fulfill our str2.isEmpty condition
		  while (longerStr.startsWith(shorterStr)) {
			  longerStr = longerStr.substring(shorterStr.length());
		  }
	    
		  return longerStr;
	  }

}

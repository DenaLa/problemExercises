package uniqueNumberOfOccurances;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueNumberOfOccurences {

	public static void main(String[] args) {
		int[] arr1 = {1,2,2,1,1,3};
		int[] arr2 = {1,2};
		int[] arr3 = {-3,0,1,-3,1,1,1,-3,10,0};
		
		System.out.println(uniqueOccurrences(arr1));
		System.out.println(uniqueOccurrences(arr2));
		System.out.println(uniqueOccurrences(arr3));
		

	}
	
	
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> A = new HashMap<>();
        
        for(int a: arr) {
        	A.merge(a, 1, Integer::sum);
        	//If a is not in A, create [a=1] key,value pair
        	//If a is in A, then perform Integer.sum(a.get, 1) on the value

        }
        
        Set<Integer> check = new HashSet<>();
        for (int a : A.values()) {
            check.add(a);
        }
    	
    	
    	return check.size() == A.size();
    }

}

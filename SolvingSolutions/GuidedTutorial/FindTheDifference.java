package findTheDifference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifference {

	public static void main(String[] args) {
		int nums1[] = {1,2,3};
		int nums2[] = {2,4,6};
		
		int nums3[] = {1,2,3,3};
		int nums4[] = {1,1,2,2};
		
		
		List<List<Integer>> result1 = findDifference(nums1,nums2);
		List<List<Integer>> result2 = findDifference(nums3,nums4);
		
		for(List<Integer> a : result1) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		for(List<Integer> a : result2) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		
	}
	
	  public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		  List<List<Integer>> result = new ArrayList<>();
		  Set<Integer> set1 = new HashSet<>();
	      Set<Integer> set2 = new HashSet<>();
	      
	      result.add(new ArrayList<>());
	      result.add(new ArrayList<>());
	      
	      
	      for(int A : nums1) {
	    	  set1.add(A);
	      }
	      for(int A : nums2) {
	    	  set2.add(A);
	      }
	      
	      for(int A : set1) {
	    	  if(!set2.contains(A)) {
	    		  result.get(0).add(A);
	    	  }
	      }
	      
	      for(int A : set2) {
	    	  if(!set1.contains(A)) {
	    		  result.get(1).add(A);
	    	  }
	      }
	        
	      return result;
	  }

}

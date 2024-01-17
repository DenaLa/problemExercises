package maxNumbersOfKSumPairs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class MaxNumberOfKSumPairs {
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4};
		int k1 = 5;
		
		int nums2[] = {3,1,3,4,3};
		int k2 = 6;
		
		
		System.out.println(maxOperations(nums1,k1));
		System.out.println(maxOperations(nums2,k2));
		
		
	}
	
	public static int maxOperations(int[] nums, int k) {
		Arrays.sort(nums);
		int count = 0;
		int A = 0;
		int B = nums.length-1;
		
		
		while(A < B) {
			
			int sum = nums[A] + nums[B];
			if(sum == k) {
				count++;
				A++;
				B--;
			}
			else if(sum < k) {
				A++;
			}
			else if(sum > k) {
				B--;
			}
			
			
		}
		
		
	    return count;
    }
}

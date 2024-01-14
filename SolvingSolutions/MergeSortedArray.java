package mergeSortedArrays;

import java.util.Arrays;

public class MergeSortedArray {
	
	public static void main(String args[]) {
		int a1[] = {1,2,3,0,0,0};
		int m1 = 3;
		int a2[] = {2,5,6};
		int n1 = 3; 
		
		merge(a1,m1,a2,n1);
		
		int b1[] = {1};
		int m2 = 1;
		int b2[] = new int[] {};
		int n2 = 0; 
		
		merge(b1,m2,b2,n2);
		
		int c1[] = {1};
		int m3 = 1;
		int c2[] = {0};
		int n3 = 0; 
		
		merge(c1,m3,c2,n3);
		
		for(int i = 0; i<a1.length; i++) {
			System.out.print(a1[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i<b1.length; i++) {
			System.out.print(b1[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i<c1.length; i++) {
			System.out.print(c1[i] + " ");
		}
		System.out.println();
		
		
	} 
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		/*int j = 0;
		if(n != 0) {
        	for(int i = m; i<nums1.length; i++ ) {
        		nums1[i] = nums2[j];
        		j++;
        	}
        	
        	Arrays.sort(nums1); 
        	
        } */ //made before I realized this was a two pointer problem
		
		int pointerA = m-1;
		int pointerB = n-1;
		int pointerC = nums1.length -1;
		
		
		
		if(n != 0) {
			while(pointerB >= 0) {
				if(pointerA >= 0 && nums1[pointerA] > nums2[pointerB]) {
					nums1[pointerC] = nums1[pointerA];
					pointerC--;
					pointerA--;
				}
				else {
					nums1[pointerC] = nums2[pointerB];
					pointerC--;
					pointerB--;
				}
			}
		}
		
		
		
    }//merge

}

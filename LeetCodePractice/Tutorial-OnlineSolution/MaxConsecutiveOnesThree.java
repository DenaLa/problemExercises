package maxConsecutiveOnesThree;

public class MaxConsecutiveOnesThree {
	public static void main(String[] args) {
		int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
		int k1 = 2;
		
		int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k2 = 3;
		
		
		System.out.println(longestOnes(nums1,k1));
		System.out.println(longestOnes(nums2,k2));
		
	}
	
	
    public static int longestOnes(int[] nums, int k) {
        int A = 0;
        int B = 0;
        int flipped = 0;
        
        
        while(B < nums.length) {
//        	System.out.println("B is " + B + ", element " + (B+1) + " in nums");
        	if(nums[B] == 0) {
//      		System.out.println("B is has encountered a zero");
        		flipped++;
//      		System.out.println("Flipped elements: " + flipped);
        	}
        	B++;
        	if(flipped > k ) {
//       		System.out.println("A is " + A + ", element " + (A+1) + " in nums");
        		if(nums[A] == 0) {
//      			System.out.println("A is has encountered a zero");
        			flipped--;
//       			System.out.println("Flipped elements: " + flipped);
        		}
        		A++;
        	}
        }
    	
    	return B-A;
    }
}

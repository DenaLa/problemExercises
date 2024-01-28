package removeDuplicates;

public class RemoveDuplicates {
	public static void main(String args[]) {
		int[] nums1 = {1,1,2};
		int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
		
		int ans1 = removeDuplicates(nums1);
		
		for(int a : nums1) {
			System.out.print(a + " ");
		}
		System.out.println();
		System.out.println(ans1);
		
		
		int ans2 = removeDuplicates(nums2);
		
		for(int a : nums2) {
			System.out.print(a + " ");
		}
		System.out.println();
		System.out.println(ans2);
		
	}
	
	public static int removeDuplicates(int[] nums) {
        int A = 1;
        //Spiritual pointer I: Runs through the array
        
        for(int I = 1; I < nums.length; I++) {
        	if( nums[I] > nums[A-1]) {
        		nums[A] = nums[I];
        		A++;
        	}
        }
       
        
        return A;
    }
	
}

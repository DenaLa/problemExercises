package removeElement;

public class RemoveElement {

	public static void main(String[] args) {
		int[] a = {3,2,2,3};
		int val1 = 3;
		
		int[] b = {0,1,2,2,3,0,4,2};
		int val2 = 2;
		
		for(int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		int ans1 = removeElement(a,val1);
		
		for(int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(ans1);
		
		
		for(int i : b) {
			System.out.print(i + " ");
		}
		System.out.println();
		int ans2 = removeElement(b,val2);
		
		for(int i : b) {
			System.out.print(i + " ");
		}
		System.out.println(); 
		System.out.println(ans2);
		
		
	}
	
	public static int removeElement(int[] nums, int val) {
	/*	int B = 0;
		int A = nums.length - 1;
		int amount = 0; //values that are not equal to val
	
		
		
		if(nums.length != 0) {
			while(B != A) {
				if(nums[B] != val) {

					B++;
					System.out.println("Amount: " + amount + "\n\n");
				}
				else {
					if(nums[A] != val){
						int temp = nums[A];
						nums[A] = nums[B];
						nums[B] = temp;
						A--;
						B++;
					}
					else {
						A--;
					}
				}
			}//while
			
			for(int a : nums) {
				if(a != val) {
					amount++;
				}
			}
		} */ //first solution. Did not past some of the tests, failed to take into account that
		//the end of the array's values could be anything
		
		int A = 0;
		
		for(int i : nums) {
			if(i != val) {
				nums[A] = i;
				A++;
			}
		}
		
		return A;
		
		//the new code counts and replaces at the same time

    }//function

}

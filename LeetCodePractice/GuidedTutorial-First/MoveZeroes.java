package moveZeroes;

public class MoveZeroes {

	public static void main(String[] args) {
		int numsA[] = {0,1,0,3,12};
		int numsB[] = {0};
		
		moveZeroes(numsA);
		moveZeroes(numsB);
		
		for(int a : numsA) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		for(int a : numsB) {
			System.out.print(a + " ");
		}

	}
	
	public static void moveZeroes(int[] nums) {
        int A = 0;
        
        for(int I : nums) {
        	if(I != 0) {
        		nums[A] = I;
        		A++;
        	}
        }
        
        while(A < nums.length) {
        	nums[A++] = 0;
        }
        
    }

}

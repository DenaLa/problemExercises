package removeDuplicatesTwo;

public class RemoveDuplicatesTwo {
	public static void main(String args[]) {
		int numsA[] = {1,1,1,2,2,3};
		int numsB[] = {0,0,1,1,1,1,2,3,3};
		
		int ansA = removeDuplicatesA(numsA);
		
		for(int A : numsA) {
			System.out.print(A + " ");
		}
		System.out.println();
		System.out.println(ansA);
		
		
		int ansB = removeDuplicatesA(numsB);
		
		for(int A : numsB) {
			System.out.print(A + " ");
		}
		System.out.println();
		System.out.println(ansB);
		
		
	}
	
	public static int removeDuplicatesA(int[] nums) {
		int A = 2;
        //Spiritual pointer I: Runs through the array
        
        for(int I = 2; I < nums.length; I++) {
        	if( nums[I] > nums[A-2]) {
        		nums[A] = nums[I];
        		A++;
        	}
        }
       
        
        return A;
    }
	
	
	public static int removeDuplicatesB(int[] nums) {
        int A = 1;
        int clones = 0; //counts the amount of duplicates of a given number we have
        //Pointer I will go through the array
        
        for(int I = 1; I < nums.length; I++) {
        	if(nums[I] == nums[I-1]) {
        		clones++;
        	}
        	else {
        		clones = 0;
        	}
        	
        	if(clones < 2) {
        		nums[A] = nums[I];
        		A++;
        	}
        }
        
        return A;
    }
}

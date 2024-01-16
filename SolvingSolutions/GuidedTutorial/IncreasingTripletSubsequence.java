package increasingTripletSubsequence;

public class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		int numsA[] = {1,2,3,4,5};
		int numsB[] = {5,4,3,2,1};
		int numsC[] = {2,1,5,0,4,6};
		
		System.out.println(increasingTriplet(numsA));
		System.out.println(increasingTriplet(numsB));
		System.out.println(increasingTriplet(numsC));
		

	}
	
	public static boolean increasingTriplet(int[] nums) {
        int A = Integer.MAX_VALUE;
        int B = Integer.MAX_VALUE;
        
        
        for(int C : nums) {
        	if(C <= A) { //C <= A
        		A = C;
        	}
        	else if(C <= B) { // C > A but n<=B
        		B = C;
        	}
        	else { // C > A, C > B. Which would make A < B < C
        		return true;
        	}
        }
		

		return false;
    }
	

}

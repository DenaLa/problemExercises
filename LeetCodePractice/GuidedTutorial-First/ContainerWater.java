package containerWater;

public class ContainerWater {
	public static void main(String[] args) {
		int[] heightA = {1,8,6,2,5,4,8,3,7};
		int[] heightB = {1,1};
		
		
		System.out.println(maxArea(heightA));
		System.out.println(maxArea(heightB));
		
		
		
	}
	
	public static int maxArea(int[] height) {
       int max = 0;
       int A = 0;
       int B = height.length-1;
       
       while(A < B) {
    	   int min = Math.min(height[A], height[B]);
    	   max = Math.max(max, min * (B-A));
    	   
    	   if(height[A] < height[B]) {
    		   A++;
    	   }
    	   else {
    		   B--;
    	   }
       }
       
       
       return max; 
    }

}

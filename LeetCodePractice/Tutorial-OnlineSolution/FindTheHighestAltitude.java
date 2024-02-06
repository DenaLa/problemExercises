package findTheHighestAltitude;

public class FindTheHighestAltitude {
	public static void main(String[] args) {
		int[] gain1 = {-5,1,5,0,-7};
		int[] gain2 = {-4,-3,-2,-1,4,3,2};
		
		System.out.println(largestAltitude(gain1));
		System.out.println(largestAltitude(gain2));
	}
	
	public static int largestAltitude(int[] gain) {
        int alt[] = new int[gain.length+1];
        int max = 0;
        alt[0] = 0;
        
        for(int i = 1; i < alt.length; i++) {
        	alt[i] = alt[i-1] + gain[i-1]; 
        	max = Math.max(max, alt[i]);
        }
		
		return max;
    }
}

package productExceptSelf;

public class ProductExceptSelf {

	public static void main(String[] args) {
		int numsA[] = {1,2,3,4};
		int numsB[] = {-1,1,0,-3,3};
		
		for(int a : productExceptSelf(numsA)) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		for(int a : productExceptSelf(numsB)) {
			System.out.print(a + " ");
		}
		System.out.println();

	}
	
	public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        
        
        ans[0] = 1;
        for(int I = 1; I<n; I++) {
        	ans[I] = ans[I-1] * nums[I-1];
        }
        
        int suffix = 1;
        for(int I = n-1 ; I > -1; I--) {
        	ans[I] *= suffix;
        	suffix *= nums[I];
        }
        
        
        
        return ans;
    }

}

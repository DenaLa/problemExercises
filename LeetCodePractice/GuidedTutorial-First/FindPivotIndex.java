package findPivotIndex;

public class FindPivotIndex {

	public static void main(String[] args) {
		int nums1[] = {1,7,3,6,5,6};
		int nums2[] = {1,2,3};
		int nums3[] = {2,1,-1};
		
		
		System.out.println(pivotIndex(nums1));
		System.out.println(pivotIndex(nums2));
		System.out.println(pivotIndex(nums3));

	}
	
    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        int pre[] = new int[len];
        int suf[] = new int[len];
        
        suf[len-1] = nums[len-1];
        pre[0] = nums[0];
        int B = 0;
        
        for(int A = 1; A < len; A++) {
        	B = len - A - 1;
        	suf[B] = suf[B+1] + nums[B];
        	pre[A] = pre[A-1] + nums[A];
        }
        
        
        for(int i = 0; i<len; i++) {
        	if(pre[i] == suf[i]) {
        		return i;
        	}
        }
        
        

    	return -1;
    }

}

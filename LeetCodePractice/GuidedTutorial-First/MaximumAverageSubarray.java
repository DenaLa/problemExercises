package maximumAverageSubarray;

public class MaximumAverageSubarray {

	public static void main(String[] args) {
		int nums1[] = {1,12,-5,-6,50,3};
		int k1 = 4;
		
		int nums2[] = {5};
		int k2 = 1;
		
		
		
		System.out.println(findMaxAverage(nums1, k1));
		System.out.println(findMaxAverage(nums2, k2));
		
		

	}
	
    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double maxSum = 0;
        
        for(int i = 0; i<k;i++) {
        	sum += nums[i];
        }
        maxSum = sum;
        
        for(int i = k; i<nums.length; i++) {
        	sum += nums[i] - nums[i-k];
        	maxSum = Math.max(sum, maxSum);
        }

    	return maxSum/k;
    }

}

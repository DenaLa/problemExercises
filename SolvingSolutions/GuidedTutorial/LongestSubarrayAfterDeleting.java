package longestSubarrayAfterDeleting;

public class LongestSubarrayAfterDeleting {

	public static void main(String[] args) {
		int nums1[] = {1,1,0,1};
		int nums2[] = {0,1,1,1,0,1,1,0,1};
		int nums3[] = {1,1,1};
		
		System.out.println(longestSubarray(nums1));
		System.out.println(longestSubarray(nums2));
		System.out.println(longestSubarray(nums3));
		
	}
	
    public static int longestSubarray(int[] nums) {
        int ans = 0;
        int zeroes = 0;
        int A = 0;
        
        for(int B = 0; B< nums.length; B++){
        	if(nums[B] == 0) {
        		zeroes++;
        	}
        	while(zeroes == 2) {
        		if(nums[A] == 0) {
        			zeroes--;
        		}
        		A++;
        	}
        	ans = Math.max(ans, B-A);
        }

        return ans;
    }

}

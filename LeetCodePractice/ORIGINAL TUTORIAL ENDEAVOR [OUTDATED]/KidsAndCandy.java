package kidsAndCandy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsAndCandy {
	public static void main(String args[]) {
		int candiesA[] = {2,3,5,1,3};
		int extraA = 3;
		
		int candiesB[] = {4,2,1,1,2};
		int extraB = 1;
		
		int candiesC[] = {12,1,12};
		int extraC = 10;
		
		List<Boolean> ansA = kidsWithCandies(candiesA, extraA);
		List<Boolean> ansB = kidsWithCandies(candiesB, extraB);
		List<Boolean> ansC = kidsWithCandies(candiesC, extraC);
		
		
		for(boolean ans : ansA) {
			System.out.print(ans + " ");
		}
		System.out.println();
		
		for(boolean ans : ansB) {
			System.out.print(ans + " ");
		}
		System.out.println();
		
		for(boolean ans : ansC) {
			System.out.print(ans + " ");
		}
		System.out.println();
		
	}
	
	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int mostCandy = Arrays.stream(candies).max().getAsInt();
        
        for(int candy : candies) {
        	ans.add((candy + extraCandies) >= mostCandy);
        }
        
        return ans;
    }
}

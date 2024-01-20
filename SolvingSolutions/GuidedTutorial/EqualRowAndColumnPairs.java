package equalRowAndColumnPairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {

	public static void main(String[] args) {
		int[][] grid1 = {{3,2,1},{1,7,6},{2,7,7}};
		int[][] grid2 = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
		
		System.out.println(Arrays.toString(grid1[0]));
		
		System.out.println(equalPairs(grid1));
		System.out.println(equalPairs(grid2));

	}
	
    public static int equalPairs(int[][] grid) {
        int len = grid.length; //Initialize the length of the grid, assuming it's a square
        int ans = 0; //Initialize the answer.
        
        for(int i = 0; i<len;i++) { //This goes through the rows. Moves every time we finish exploring columns
        	for(int j = 0; j< len; j++) { //this goes through the columns. Resets every time we go to a new row.
        		int k = 0; //this helps us compare elements
        		for(; k < len; k++) {
        			if(grid[i][k] != grid [k][j]) { //if at any point in our comparison, two units don't line up, break out
        				break;
        			}
        		}
        		if(k == len) { //if k was able to reach len, it means the row and the column matched
        			ans++;
        		}
        	}
        	
        }
    	
    	return ans;
    }

}

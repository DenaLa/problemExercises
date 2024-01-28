package graphsDFS;

public class NumberofProvinces {

	public static void main(String[] args) {
		int citiesA[][] = {{1,1,0},{1,1,0},{0,0,1}};
		int citiesB[][] = {{1,0,0},{0,1,0},{0,0,1}};
		
		
		System.out.println(findCircleNum(citiesA));
		System.out.println(findCircleNum(citiesB));

	}
	
    public static int findCircleNum(int[][] isConnected) {
        int ans = 0;
        boolean[] visited = new boolean[isConnected.length];
        
        for(int i = 0; i< isConnected.length; i++) {
        	if(!visited[i]) {
        		ans++;
        		dfs(isConnected, visited, i);
        	}
        }
        
    	
    	return ans;
    }
    
    public static void dfs(int[][] isConnected, boolean[] visited, int i) {
    	visited[i] = true;
    	
    	for(int j = 0; j < isConnected.length; j++) {
    		if(isConnected[i][j] == 1 && !visited[j]) {
    			dfs(isConnected, visited, j);
    		}
    	}
    	
    }

}

package graphsDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {

	public static void main(String[] args) {
		//Keys (not used, just here to show what they are
		int[][] k1 = {{1},{2},{3},{}};
		int[][] k2 = {{1,3},{3,0,1},{2},{0}};
		
		List<Integer> a = new ArrayList<>(Arrays.asList(1));
		List<Integer> b = new ArrayList<>(Arrays.asList(2));
		List<Integer> c = new ArrayList<>(Arrays.asList(3));
		List<Integer> d = new ArrayList<>(Arrays.asList());
		
		List<Integer> e = new ArrayList<>(Arrays.asList(1,3));
		List<Integer> f = new ArrayList<>(Arrays.asList(3,0,1));
		List<Integer> g = new ArrayList<>(Arrays.asList(2));
		List<Integer> h = new ArrayList<>(Arrays.asList(0));
		
		List<List<Integer>> rooms1 = new ArrayList<>();
		List<List<Integer>> rooms2 = new ArrayList<>();
		
		rooms1.add(a);
		rooms1.add(b);
		rooms1.add(c);
		rooms1.add(d);
		
		rooms2.add(e);
		rooms2.add(f);
		rooms2.add(g);
		rooms2.add(h);
		
		System.out.println(canVisitAllRooms(rooms1));
		System.out.println(canVisitAllRooms(rooms2));
		
		

	}
	
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] seen = new int[rooms.size()];
        int node = 0;
        dfs(rooms, node, seen);
    	
    	return Arrays.stream(seen).allMatch(a -> a==1);
    }
    
    public static void dfs(List<List<Integer>> rooms, int currentRoom, int[] seen) {
    	seen[currentRoom] = 1;
    	for(int child : rooms.get(node)) {
    		if(seen[child] == 0) {
    			dfs(rooms, child, seen);
    		}
    	}

    }

}

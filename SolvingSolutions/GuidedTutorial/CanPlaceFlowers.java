package canPlaceFlowers;

public class CanPlaceFlowers {
	public static void main (String[] args) {
		int[] flowerbed = {1,0,0,0,1};
		int nA = 1;
		int nB = 2;
		
		boolean ansA =  canPlaceFlowers(flowerbed, nA);
		boolean ansB =  canPlaceFlowers(flowerbed, nB);
		
		System.out.println(ansA);
		System.out.println(ansB);
		
		
		
	}
	
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		if(n == 0) {
			return true;
		}
		
		for(int i = 0 ; i < flowerbed.length; i++) {
			if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
				flowerbed[i] = 1;
				n--;
			}
			if(n == 0) {
				return true;
			}
		}
		
		return false;
    }
	
}

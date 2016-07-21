
public class FloodFillAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] screen = {	{1, 1, 1, 1, 1, 1, 1, 1},
                			{1, 1, 1, 1, 1, 1, 0, 0},
                			{1, 0, 0, 1, 1, 0, 1, 1},
                			{1, 2, 2, 2, 2, 0, 1, 0},
                			{1, 1, 1, 2, 2, 0, 1, 0},
                			{1, 1, 1, 2, 2, 2, 2, 0},
                			{1, 1, 1, 1, 1, 2, 1, 1},
                			{1, 1, 1, 1, 1, 2, 2, 1},
               			};
		int seedX = 4;
		int seedY = 4;
		floodfillUtil(screen, seedX, seedY, screen[seedX][seedY], 3);
		Utils.printMatrix(screen);
	}

	private static void floodfillUtil(int[][] screen, int x, int y, int prevC, int newC) {
		// TODO Auto-generated method stub
		if(x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) return;
		if(screen[x][y] != prevC) return;
		screen[x][y] = newC;
		floodfillUtil(screen, x -1, y, prevC, newC);
		floodfillUtil(screen, x, y-1, prevC, newC);
		floodfillUtil(screen, x + 1, y, prevC, newC);
		floodfillUtil(screen, x, y+1, prevC, newC);
	}

}


public class MinInitialPointToReachDest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {		{-2,-3, 3},
                				{-5,-10,1},
                				{10,30,-5}
              				};
		int resultRec = getMinInitialPointRec(points, 0, 0);
		System.out.println("Min Coins Rec : "+ resultRec);
		getMinInitialPointsDP(points);
	}

	private static int getMinInitialPointRec(int[][] points, int x, int y) {
		if(x == points.length - 1 && y == points[0].length -1){
			if(points[points.length - 1][points[0].length -1] > 0) return 1;
			else return Math.abs(points[points.length - 1][points[0].length -1]) + 1;
		}
		if(x >= points.length || y >= points[0].length ) return Integer.MIN_VALUE;
		
		int forward = getMinInitialPointRec(points, x, y + 1);
		int down = getMinInitialPointRec(points, x + 1, y);
		
		int forwardCoin = (points[x][y] - forward > 0 ? 1 : Math.abs(points[x][y] - forward));
		int downCoin = (points[x][y] - down > 0 ? 1 : Math.abs(points[x][y] - down));
		return Utils.min(forwardCoin, downCoin);
	}
	private static void getMinInitialPointsDP(int[][] points){
		int rows = points.length;
		int cols = points[0].length;
		int[][] coinMatrix = new int[rows][cols];
		coinMatrix[rows - 1][cols - 1] = points[rows - 1][cols - 1] > 0 ? 1 : Math.abs(points[rows - 1][cols - 1]) + 1;
		for(int i = rows - 2; i >= 0; i--){
			coinMatrix[i][cols - 1] = points[i][cols - 1] - coinMatrix[i + 1][cols - 1] > 0 ? 1 : Math.abs(points[i][cols - 1] - coinMatrix[i + 1][cols - 1]);
		}
		for(int i = cols - 2; i >= 0; i--){
			coinMatrix[rows - 1][i] = points[rows - 1][i] - coinMatrix[rows - 1][i + 1] > 0 ? 1 : Math.abs(points[rows - 1][i] - coinMatrix[rows - 1][i + 1]);
		}
		for(int i = rows - 2; i >= 0 ; i--){
			for(int j = cols - 2; j >= 0; j--){
				int minFromNext = Utils.min(coinMatrix[i][j+1], coinMatrix[i+1][j]);
				coinMatrix[i][j] = points[i][j] - minFromNext > 0 ? 1 : Math.abs(points[i][j] - minFromNext);
			}
		}
		Utils.printMatrix(coinMatrix);
	}
}

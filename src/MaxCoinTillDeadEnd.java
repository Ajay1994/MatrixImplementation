
public class MaxCoinTillDeadEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {	{'E', 'C', 'C', 'C', 'C'},
							{'C', '#', 'C', '#', 'E'},
							{'#', 'C', 'C', '#', 'C'},
							{'C', 'E', 'E', 'C', 'E'},
							{'C', 'E', '#', 'C', 'E'}
              			};
		//1 - right & 0 - left
		int coins = getMaxCoinsRec(matrix, 0, 0, 1);
		System.out.println("Max Coins Rec : "+ coins);
		
		int[][][] dp = new int[matrix.length][matrix[0].length][3];
		dp = Utils.fill3DMatrix(dp, -1);
		int countDP = getMaxCoinsDP(matrix, dp, 0, 0, 1 );
		System.out.println("Max Coins DP : "+ countDP);
	}
	private static int getMaxCoinsDP(char[][] matrix, int[][][] dp, int m, int n, int direction) {
		// TODO Auto-generated method stub
		if(!isValid(m, n, matrix)) return 0;
		if(matrix[m][n] == '#') return 0;
		
		if(dp[m][n][direction] != -1) return dp[m][n][direction];
		
		if(matrix[m][n] == 'E') dp[m][n][direction] = 0;
		else if(matrix[m][n] == 'C') dp[m][n][direction] = 1;
		
		if(direction == 0){
			dp[m][n][direction] += Utils.max(getMaxCoinsDP(matrix, dp, m, n - 1, 0 ), getMaxCoinsDP(matrix, dp, m+1, n, 1));
		}else{
			dp[m][n][direction] += Utils.max(getMaxCoinsDP(matrix, dp, m, n + 1, 1), getMaxCoinsDP(matrix, dp, m+1, n, 0));
		}
		
		return dp[m][n][direction];
	}
	// to check whether current cell is out of the grid or not
	public static boolean isValid(int i, int j, char[][] matrix)
	{
	    return (i >=0 && i < matrix.length && j >=0 && j < matrix[0].length);
	}
	private static int getMaxCoinsRec(char[][] matrix, int m, int n, int direction) {
		// TODO Auto-generated method stub
		if(!isValid(m, n, matrix)) return 0;
		if(matrix[m][n] == '#') return 0;
		int result = 0;
		if(matrix[m][n] == 'E') result = 0;
		else if(matrix[m][n] == 'C') result = 1;
		
		if(direction == 0){
			return result + Utils.max(getMaxCoinsRec(matrix, m, n - 1, 0),
					getMaxCoinsRec(matrix, m + 1, n, 1));
		}else{
			return result + Utils.max(getMaxCoinsRec(matrix, m, n + 1, 1),
					getMaxCoinsRec(matrix, m + 1, n, 0));
		}
	}
	
}


public class PathsWithKCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 12;
	    int[][] matrix = { 	{1, 2, 3},
	                      	{4, 6, 5},
	                      	{3, 2, 1}
	                  	};
	    int countRec = numPathRec(matrix, matrix.length -1 , matrix[0].length -1, k);
	    System.out.println("Recursive :" + countRec);
	    
	    int[][][] dp = new int[matrix.length][matrix[0].length][k + 10];
		dp = Utils.fill3DMatrix(dp, -1);
	    int countDP = numPathDP(matrix,dp,matrix.length -1 , matrix[0].length -1, k);
	    System.out.println("DP Approach : "+ countDP);
	}

	private static int numPathDP(int[][] matrix,int[][][] dp, int m, int n, int k) {
		// TODO Auto-generated method stub
		if(m < 0 || n < 0) return 0;
		if(m == 0 && n == 0){
			if(k == matrix[m][n]) return 1;
			else return 0;
		}
		if(dp[m][n][k] != -1) return dp[m][n][k];
		
		dp[m][n][k] = numPathDP(matrix, dp, m - 1, n, k - matrix[m][n]) + numPathDP(matrix, dp, m, n -1, k - matrix[m][n]);
		return dp[m][n][k];
	}

	private static int numPathRec(int[][] matrix, int m, int n, int k) {
		// TODO Auto-generated method stub
		if(!Utils.isvalid(m, n, matrix)) return 0;
		if(m == 0 && n == 0){
			if(k == matrix[m][n]) return 1;
			else return 0;
		}
		return numPathRec(matrix, m - 1, n, k - matrix[m][n]) + numPathRec(matrix, m, n -1, k - matrix[m][n]);
	}

}

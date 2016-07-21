
public class MaximumLengthhPathFromGivenCell {

	static int mx[] = {0, 1, 1, -1, 1, 0, -1, -1};
	static int my[] = {1, 0, 1, 1, -1, -1, 0, -1};
	public static boolean isvalid(int i, int j, char [][] matrix)
	{
	    if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
	      return false;
	    return true;
	}
	public static boolean isadjacent(char prev, char curr)
	{
	    return ((curr - prev) == 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = { { 'a', 'c', 'd'},
                			{ 'h', 'b', 'e'},
                			{ 'i', 'g', 'f'}
                	   		};
		int result = getMaxLengthPath(matrix, 'a');
		System.out.println("Maximum Length Path : "+ result);
	}
	
	private static int getMaxLengthPath(char[][] matrix, char ch) {
		// TODO Auto-generated method stub
		int[][] dp = new int[matrix.length][matrix[0].length];
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		dp = Utils.fillMatrix(dp, -1);
		//Utils.printMatrix(dp);
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(matrix[i][j] == ch){
					//System.out.println("Found at location : "+ i + " and "+ j);
					int result = fillMaxUtil(dp, matrix, i, j);
					Utils.printMatrix(dp);
					return result;
				}
			}
		}
		return 0;
	}
	
	private static int fillMaxUtil(int[][] dp, char[][] matrix, int x, int y) {
		// TODO Auto-generated method stub
		if(isvalid(x, y, matrix) == false) return 0;
		if(dp[x][y] != -1) return dp[x][y];
		int ans = 1;
		for(int k = 0; k < 8 ; k++){
			if(isvalid(x + mx[k], y + my[k], matrix) && isadjacent(matrix[x][y], matrix[x + mx[k]][y + my[k]])){
				//System.out.println("Loc : "+ (x + mx[k]) + " | "+ (y + my[k]));
				ans = 1 + Utils.max(ans, fillMaxUtil(dp, matrix, x + mx[k], y + my[k]));
			}
		}
		dp[x][y] = ans;
		//Utils.printMatrix(dp);
		//System.out.println("Answer :"+ ans);
		return ans;
	}

}

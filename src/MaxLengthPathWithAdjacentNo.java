import javax.naming.PartialResultException;

public class MaxLengthPathWithAdjacentNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]  matrix = {	{1, 2, 9},
                			{5, 3, 8},
                			{4, 6, 7}};
		int[][] pathMatrix = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				pathMatrix[i][j] = -1;
			}
		}
		int result = 1;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				getMaxLengthPathFromCell(matrix, pathMatrix, i, j);
				result = Utils.max(result, pathMatrix[i][j]);
			}
		}
		System.out.println("Max Length Path Rec : "+result);
	}

	private static int getMaxLengthPathFromCell(int[][] matrix, int[][] pathMatrix, int x, int y) {
		// TODO Auto-generated method stub
		int rows = matrix.length;
		int cols = matrix[0].length;
		if(x >= rows || x < 0 || y >= cols || y < 0) return 0;
		if(pathMatrix[x][y] != -1) return pathMatrix[x][y];
		
		// Since all numbers are unique and in range from 1 to n*n,
	    // there is atmost one possible direction from any cell
		if(y > 0 && matrix[x][y - 1] == matrix[x][y] + 1){
			pathMatrix[x][y] = 1 + getMaxLengthPathFromCell(matrix, pathMatrix, x, y - 1);
			return pathMatrix[x][y];
		}
		if(y < cols - 1 && matrix[x][y + 1] == matrix[x][y] + 1){
			pathMatrix[x][y] = 1 + getMaxLengthPathFromCell(matrix, pathMatrix, x, y + 1);
			return pathMatrix[x][y];
		}
		if(x > 0 && matrix[x - 1][y] == matrix[x][y] + 1){
			pathMatrix[x][y] = 1 + getMaxLengthPathFromCell(matrix, pathMatrix, x - 1, y);
			return pathMatrix[x][y];
		}
		if(x < rows - 1 && matrix[x + 1][y] == matrix[x][y] + 1){
			pathMatrix[x][y] = 1 + getMaxLengthPathFromCell(matrix, pathMatrix, x + 1, y);
			return pathMatrix[x][y];
		}
		pathMatrix[x][y] = 1;
		return pathMatrix[x][y];
	}
	

}

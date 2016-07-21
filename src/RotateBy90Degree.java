
public class RotateBy90Degree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] matrix = {
			        		{1, 2, 3, 4 , 100},
			        		{5, 6, 7, 8, 200},
			        		{9, 10, 11, 12, 300},
			        		{19, 110, 111, 112, 3000},
			        		{13, 14, 15, 16, 400}
		 				   };
		 rotateMatrixBy90(matrix);
	}

	private static void rotateMatrixBy90(int[][] matrix) {
		// TODO Auto-generated method stub
		int rows = matrix.length;
		int cols = matrix[0].length;
		for(int i = 0; i < 2; i++){
			for(int j = i; j < cols - 1 - i; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[rows - j -1][i];
				matrix[rows - j - 1][i] = matrix[rows - i -1][cols - j - 1];
				matrix[rows - i -1][cols - j - 1] = matrix[j][cols - i - 1];
				matrix[j][cols - i - 1] = temp;
			}
		}
		Utils.printMatrix(matrix);
	}
}

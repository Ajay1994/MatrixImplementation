
public class MaximumSizeSquareOfOne {
	public static void main(String[] args) {
		int[][] matrix =  {{0, 1, 1, 0, 1}, 
						   {1, 1, 0, 1, 0}, 
						   {0, 1, 1, 1, 0},
						   {1, 1, 1, 1, 0},
						   {1, 1, 1, 1, 1},
						   {0, 0, 0, 0, 0}};
             
		printMaxSubSquare(matrix);
	}

	private static void printMaxSubSquare(int[][] matrix) {
		// TODO Auto-generated method stub
		int[][] sumMatrix = new int[matrix.length][matrix[0].length];
		int rows = matrix.length;
		int cols = matrix[0].length;
		for(int i = 0; i < cols; i++) sumMatrix[0][i] = matrix[0][i];
		for(int i = 0; i < rows; i++) sumMatrix[i][0] = matrix[i][0];
		int max_row = 0;
		int max_col = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < rows; i++){
			for(int j = 1; j < cols; j++){
				if(matrix[i][j] == 1)
					sumMatrix[i][j] = Utils.minThree(sumMatrix[i-1][j], sumMatrix[i][j-1], sumMatrix[i-1][j-1]) + 1;
				else
					sumMatrix[i][j] = 0;
				if(sumMatrix[i][j] > max){
					max_row = i;
					max_col = j;
					max = sumMatrix[i][j];
				}
			}
		}
		Utils.printMatrix(sumMatrix);
		System.out.println("Maximum position is : ("+max_row+","+max_col+")"+ " and max value : "+max);
	}
}


public class PrintSubSquaresOfSizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix  = { {1, 1, 1, 1, 1},
						 {2, 2, 2, 2, 2},
						 {3, 3, 3, 3, 3},
						 {4, 4, 4, 4, 4},
						 {5, 5, 5, 5, 5},
					   };
		int k = 3;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] sumMatrix = new int[rows - k + 1][cols];
		for(int i = 0; i < cols; i++){
			int stripSum = 0;
			for(int j = 0; j < k; j++){
				stripSum += matrix[j][i];
			}
			sumMatrix[0][i] = stripSum;
		}
		for(int i = 1; i < sumMatrix.length ; i++){
			for(int j = 0; j < cols; j++){
				sumMatrix[i][j] = sumMatrix[i-1][j] - matrix[i - 1][j] + matrix[k + i -1][j];
			}
		}
		Utils.printMatrix(sumMatrix);
		System.out.println("Result :");
		for(int i = 0; i < sumMatrix.length; i++){
			int sum = 0;
			for(int j = 0 ; j < k; j++){
				sum += sumMatrix[i][j];
			}
			System.out.print(sum + " | ");
			for(int j = k ; j < cols; j++){
				sum = sum - sumMatrix[i][j - k] + sumMatrix[i][j];
				System.out.print(sum + " | ");
			}
			System.out.println();
		}
		
	}

}

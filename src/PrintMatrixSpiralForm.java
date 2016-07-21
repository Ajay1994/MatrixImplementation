
public class PrintMatrixSpiralForm {
	public static void main(String[] args) {
	    int[][] matrix = {
			 	{1,    2,   3,   4},
		        {5,    6,   7,   8},
		        {9,   10,  11,  12},
		        {13,  14,  15,  16}
		    };
	 
	    spiralPrint(matrix);
	}

	public static void spiralPrint(int[][] matrix) {
		// TODO Auto-generated method stub
		int rows = matrix.length;
		int cols = matrix[0].length;
		int i = 0;
		for(i = 0; i < rows/2; i++){
			for(int j = i; j < cols - i; j++){
				System.out.print(matrix[i][j] + " | ");
			}
			for(int j = i + 1; j < rows - i - 1; j++){
				System.out.print(matrix[j][cols - 1 - i] + " | ");
			}
			for(int j = cols - i - 1; j >= i; j--){
				System.out.print(matrix[rows - i - 1][j] + " | ");
			}
			for(int j = rows - i - 2; j > i; j--){
				System.out.print(matrix[j][i] + " | ");
			}
		}
		if(rows % 2 == 1){
			for(int j = i; j < cols - i; j++){
				System.out.print(matrix[i][j] + " | ");
			}
		}
		
		
		/*
		 * 				{  {1,  2,  3,  4,  5,  6},
					       {7,  8,  9,  10, 11, 12},
					       {13, 14, 15, 16, 17, 18},
					       {19, 20, 21, 22, 23, 24}
	    				 };
	    				 {
	    				 	{1,    2,   3,   4},
					        {5,    6,   7,   8},
					        {9,   10,  11,  12},
					        {13,  14,  15,  16}
					    };
		 */
		
	}
}

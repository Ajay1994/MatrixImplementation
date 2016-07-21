
public class GetIsolatedIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix =  {   {'O', 'O', 'O'},
	                		{'X', 'X', 'O'},
	                		{'X', 'X', 'O'},
	                		{'O', 'O', 'X'},
	                		{'O', 'O', 'X'},
	                		{'X', 'X', 'O'}
						};
		int rows = matrix.length;
		int cols = matrix[0].length;
		int countIslands = 0;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(matrix[i][j] == 'X'){
					if((i == 0 || matrix[i-1][j] == 'O') && (j == 0 || matrix[i][j-1] == 'O')) countIslands++;
				}
			}
		}
		System.out.println("No of Islands : "+ countIslands);
	}

}

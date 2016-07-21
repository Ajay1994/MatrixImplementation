
public class Rows0andCols1 {
	public static void main(String[] args) {
		int[][] matrix = {	{0, 0, 1, 1, 0},
                			{0, 0, 0, 1, 0},
                			{1, 1, 1, 1, 0},
                			{0, 0, 0, 0, 0},
                			{1, 1, 1, 1, 1}};
		int rows = matrix.length;
		int cols = matrix[0].length;
		int j = cols - 1;
		int i = 0;
		int result = -1;
		while(i < rows && j >= 0){
			if(matrix[i][j] == 0){
				int k = j - 1;
				for(k = j - 1; k >= 0; k--){
					if(matrix[i][k] != 0) break;
				}
				if(k == -1){
					result = i;
					break;
				}else i++;
			}else{
				int k = i + 1;
				for(k = i + 1; k < rows; k++){
					if(matrix[k][j] != 1) break;
				}
				if(k == rows){
					result = j;
					break;
				}else j--;
			}
		}
		if( result == -1) System.out.println("Not found");
		else{
			for(int k = 0 ; k < rows; k++){
				if(k != result && matrix[k][result] != 1) {
					System.out.println("Not Found");
					return;
				}
			}
			for(int k = 0 ; k < cols; k++){
				if(k != result && matrix[result][k] != 0) {
					System.out.println("Not Found");
					return;
				}
			}
			System.out.println("Result : "+ result);
		}
	}
}

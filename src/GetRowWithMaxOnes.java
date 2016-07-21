
public class GetRowWithMaxOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { {0, 0, 0, 1},
		        		   {0, 1, 1, 1},
		        		   {1, 1, 1, 1},
		        		   {0, 0, 0, 0}
		    		     };
		System.out.println("Row with Max one : "+ getRow(matrix));
		 
	}

	private static int getRow(int[][] matrix) {
		// TODO Auto-generated method stub
		int max_row = 0;
		int max_count = 0;
		int index = matrix[0].length - 1;
		int rows = matrix.length;
		int j = 0;
		while(index >= 0 && j < rows){
			if(matrix[j][index] == 1){
				int newCount = matrix[0].length - index;
				if(max_count < newCount) {
					max_row = j;
					max_count = newCount;
				}
				index--;
			}else{
				j = j + 1;
			}
		}
		System.out.println("Maximum Count of 1s : "+max_count);
		return max_row;
	}

}

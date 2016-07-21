class MaxSum{
	int start;
	int end;
	int maxValue;
	public MaxSum(int start, int end , int maxValue){
		this.start = start;
		this.end = end;
		this.maxValue = maxValue;
	}
}
public class MaximumSumRectangle2DMatrix {
	
	public static MaxSum kadaneMaxSum(int[] array){
		int current_max = array[0];
		int max_so_far = array[0];
		int endPosition = -1;
		for(int i = 1; i < array.length; i++){
			current_max = Utils.max(current_max + array[i], array[i]);
			max_so_far = Utils.max(max_so_far, current_max);
			if(max_so_far == current_max) endPosition = i;
		}
		int sum = 0;
		int j = endPosition;
		for(j = endPosition; j >=0; j--){
			if(array[j]+sum == max_so_far) break;
			sum += array[j];
		}
		return new MaxSum(j, endPosition, max_so_far);
	}
	public static void main(String[] args) {
		
		 int[][] matrix = { {1, 2, -1, -4, -20},
                 			{-8, -3, 4, 2, 1},
                 			{3, 8, 10, 1, 3},
                 			{-4, -1, 1, 7, -6}
		 				  };
		 int[] sumArray = new int[matrix.length];
		 int rows = matrix.length;
		 int cols = matrix[0].length;
		 int up = 0;
		 int down = 0;
		 int left = 0;
		 int right = 0;
		 int maxValue = 0;
		 for(int i = 0; i < cols; i++){
			 for(int j = 0; j < rows; j++){
				 sumArray[j] = matrix[j][i];
			 }
			 MaxSum result = kadaneMaxSum(sumArray);
			 if(result.maxValue > maxValue){
				 up = result.start;
				 down = result.end;
				 left = i;
				 right = i;
				 maxValue = result.maxValue;
			 }
			 for(int j = i + 1; j < cols; j++){
				 for(int k = 0; k < rows; k++){
					 sumArray[k] = sumArray[k] + matrix[k][j];
				 }
				 result = kadaneMaxSum(sumArray);
				 if(result.maxValue > maxValue){
					 up = result.start;
					 down = result.end;
					 left = i;
					 right = j;
					 maxValue = result.maxValue;
				 }
			 }
		 }
		 System.out.println("Maximum Sum : "+ maxValue);
		 System.out.println("Coordinate position is : ("+up+","+left+")"+ " and "+ "("+down+","+right+")");
	}

}


public class SearchSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { {10, 20, 30, 40},
		                {15, 25, 35, 45},
		                {27, 29, 37, 48},
		                {32, 33, 39, 50},
              };
		search(mat, 50);
	}

	private static void search(int[][] mat, int key) {
		// TODO Auto-generated method stub
		int index = mat[0].length - 1;
		int row = 0;
		while(index >= 0 && row < mat.length){
			if(mat[row][index] == key){
				System.out.println("Data Found : "+ row + " | "+index);
				return;
			}
			else if(mat[row][index] > key) index--;
			else if (mat[row][index] < key) row++;
		}
		System.out.println("Not found");
	}

}

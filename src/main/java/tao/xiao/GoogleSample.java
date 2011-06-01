package tao.xiao;

/**
 * Array traversal like this: Input: 1 2 3 4 5 6 7 8 9
 * 
 * Output: 124753689
 * 
 * @author xiaotao183
 * 
 */
public class GoogleSample {
	public static void main(String[] args) {
		int[][] input = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 }, {17, 18, 19, 20} };

		int[] output = new GoogleSample().build(input, 5, 4);

		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + ",");
		}
	}

	private int[] build(int[][] input, int row, int column) {
		int sumOfIndex = row + column - 2;
		boolean upwards = true;
		int rowIndex = 0;
		int columnIndex = 0;
		int[] output = new int[row * column];
		int i = 0;

		for (int j = 0; j <= sumOfIndex;) {
			output[i] = input[rowIndex][columnIndex];
			i++;

			if (upwards) {
				rowIndex--;
				columnIndex++;
			} else {
				rowIndex++;
				columnIndex--;
			}

			if (rowIndex == row) {
				j++;
				upwards = !upwards;
				rowIndex--;
				columnIndex = j - rowIndex;
			} else if (columnIndex < 0) {
				j++;
				columnIndex = 0;
				rowIndex = j - columnIndex;
				upwards = !upwards;
			} else if (columnIndex == column) {
				j++;
				columnIndex--;
				rowIndex = j - columnIndex;
				upwards = !upwards;
			} else if (rowIndex < 0) {
				j++;
				rowIndex = 0;
				columnIndex = j - rowIndex;
				upwards = !upwards;
			}
		}
		
		return output;
	}
}

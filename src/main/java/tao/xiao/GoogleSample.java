package tao.xiao;


/**
 * Array traversal like this: 
 * Input: 1 2 3 
 * 		  4 5 6 
 * 	      7 8 9 
 * 
 * Output: 124753689
 * 
 * @author xiaotao183
 * 
 */
public class GoogleSample {
	public static void main(String[] args) {
		int[][] input = { { 1, 2, 3, 4}, 
					      { 5, 6, 7, 8}, 
					      { 9, 10, 11, 12},
					      {13, 14, 15, 16} };
		
		int[] output = new GoogleSample().convert(input);
		
		for (int i = 0; i < output.length; i ++) {
			System.out.print(output[i] + ",");
		}
	}

	public int[] convert(int[][] input) {
		int length = input.length;
		int size = length * length;
		int[] output = new int[size];
		
		return buildLowerPart(
				input,
				buildMiddlePart(input, buildUpperPart(input, output, 0),
						(size - length) / 2), (size - length) / 2 + length);
	}
	
	private int[] buildUpperPart(int[][] input, int[] output, int startPos) {
		int length = input.length;
		
		for (int i = 0; i < length - 1; i ++) {
			for (int j = 0; j < length - i - 1; j ++) {
				output[startPos++] = input[i][j];
			}
		}
		
		return output;
	}
	
	private int[] buildMiddlePart(int[][] input, int[] output, int startPos) {
		int length = input.length;
		
		for (int i = 1, j = 0; j < length; i ++, j++) {
			output[startPos++] = input[length - i][j];
		}
		
		return output;
	}
	
	private int[] buildLowerPart(int[][] input, int[] output, int startPos) {
		int length = input.length;
		
		for (int i = 1; i < length; i ++) {
			for (int j = i; j > 0; j --) {
				output[startPos++] = input[i][length - j];
			}
		}
		
		return output;
	}
}

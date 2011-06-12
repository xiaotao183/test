package tao.xiao;

import java.util.HashSet;

public class AustralianLotto {
	private HashSet<String> drawingNumbers = new HashSet<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] result = new AustralianLotto().evalute("3 11 18 23 37 45",
				new String[] { "4 7 14 30 33 35", "3 11 18 23 37 45",
						"11 18 19 20 21 45" });
		
		for (Integer i : result) {
			System.out.print(i + ",");
		}
	}

	public int[] evalute(String drawing, String[] picks) {
		insertDrawing(drawing);

		int[] result = new int[7];

		for (String pick : picks) {
			int count = 0;
			for (String number : pick.split("\\s+")) {
				if (drawingNumbers.contains(number)) {
					count++;
				}
			}
			result[count]++;
		}

		return result;
	}

	private void insertDrawing(String drawing) {
		for (String number : drawing.split("\\s+")) {
			drawingNumbers.add(number);
		}
	}

}

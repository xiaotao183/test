package tao.xiao;

public class BillBoard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] enlarge = new BillBoard().enlarge("DOK", new String[] {
				"####.-#...#-#...#-#...#-####.",
				"#####-#...#-#...#-#...#-#####",
				"#...#-#..#.-###..-#..#.-#...#" });

		for (String string : enlarge) {
			System.out.println(string);
		}

	}

	public String[] enlarge(String message, String[] letters) {
		String[] enlarges = new String[5];

		for (String letter : letters) {
			String[] bits = letter.split("-");

			for (int i = 0; i < bits.length; i++) {
				if (enlarges[i] == null) {
					enlarges[i] = new String();
				}

				enlarges[i] += bits[i] + ".";
			}
		}

		return enlarges;
	}

}

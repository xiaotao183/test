package tao.xiao;

public class WidgetRepairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new WidgetRepairs().days(
				new int[] { 10, 0, 0, 4, 20 }, 8));
		System.out.println(new WidgetRepairs().days(new int[] { 0, 0, 0 }, 10));
		System.out
				.println(new WidgetRepairs().days(new int[] { 100, 100 }, 10));
		System.out.println(new WidgetRepairs().days(new int[] { 27, 0, 0, 0, 0,
				9 }, 9));
		System.out.println(new WidgetRepairs().days(new int[] { 6, 5, 4, 3, 2,
				1, 0, 0, 1, 2, 3, 4, 5, 6 }, 3));
	}

	public int days(int[] arrivals, int numPerDay) {
		int count = 0;
		int reminder = 0;

		for (int i = 0; i < arrivals.length; i++) {
			int numRepairs = arrivals[i] + reminder;

			if (numRepairs > 0) {
				reminder = Math.max(numRepairs - numPerDay, 0);
				count++;
			}
		}

		count += (reminder / numPerDay + (reminder % numPerDay == 0 ? 0 : 1));

		return count;
	}
}

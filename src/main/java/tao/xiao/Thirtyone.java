package tao.xiao;

import org.apache.commons.lang.StringUtils;

public class Thirtyone {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Thirtyone().findWinner(new String[] { "10 A A",
				"K 2 3" }));
		System.out.println(new Thirtyone().findWinner(new String[] { "2 3 4",
				"10 6 8", "A K 3" }));
		System.out.println(new Thirtyone().findWinner(new String[] { "J 5 2",
				"2 7 5", "10 J 2", "J 6 2", "J Q K" }));
		System.out.println(new Thirtyone().findWinner(new String[] { "Q K K",
				"10 J Q", "A 8 A", "2 2 2" }));
		System.out.println(new Thirtyone().findWinner(new String[] { "Q 6 6",
				"7 8 3", "3 7 2", "K Q 6", "Q 6 3", "5 3 8", "10 J Q", "4 8 4",
				"Q 2 5", "8 A 8", "9 10 10", "2 K 5", "10 4 5", "Q 4 Q",
				"3 J 2", "7 4 4", "3 9 7", "A 4 4", "Q 7 7", "10 9 A", "J 3 5",
				"5 8 9", "Q Q 7" }));
	}

	public int findWinner(String[] hands) {
		int index = 0;
		float max = 0;

		for (int i = 0; i < hands.length; i++) {
			String[] cards = hands[i].split("\\s+");
			float total = calculate(cards);

			if (total > max) {
				index = i;
				max = total;
			}
		}

		return index;
	}

	private float calculate(String[] cards) {
		float total = 0;

		for (String card : cards) {
			if (StringUtils.isNumeric(card)) {
				total += Integer.valueOf(card);
			} else {
				// J,Q,K
				if (!"A".equals(card)) {
					total += 10;
				} else {
					total += 11;
					if (total > 31) {
						total -= 10;
					}
				}
			}
		}

		return (float) (isIdentical(cards) ? 30.5 : total);
	}

	private boolean isIdentical(String[] cards) {
		String identicalValue = cards[0];

		for (String card : cards) {
			if (!identicalValue.equals(card)) {
				return false;
			}
		}

		return true;
	}
}

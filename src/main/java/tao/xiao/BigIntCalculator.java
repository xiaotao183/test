package tao.xiao;

public class BigIntCalculator {
	public static void main(String[] args) {
		System.out.println(new BigIntCalculator().add("999234", "9939"));
	}

	public String add(String s1, String s2) {
		String minString = s1.length() > s2.length() ? s2 : s1;
		String maxString = minString.equals(s1) ? s2 : s1;
		StringBuilder subTotal = new StringBuilder();
		boolean isAdding = false;

		for (int i = 1; i <= minString.length(); i++) {
			int bit1 = Integer.valueOf(String.valueOf(minString
					.charAt(minString.length() - i)));
			int bit2 = Integer.valueOf(String.valueOf(maxString
					.charAt(maxString.length() - i)));

			int digitTotal = bit1 + bit2 + (isAdding ? 1 : 0);

			if (digitTotal >= 10) {
				digitTotal -= 10;
				isAdding = true;
			} else {
				isAdding = false;
			}

			subTotal.insert(0, digitTotal);
		}

		String prefix = maxString.substring(0,
				maxString.length() - subTotal.length());
		if (isAdding) {
			prefix = addOne(prefix);
		}

		return prefix + subTotal.toString();
	}

	private String addOne(String number) {
		boolean isAdding = true;
		StringBuilder subTotal = new StringBuilder();

		for (int i = 1; i <= number.length(); i++) {
			int digitTotal = Integer.valueOf(String.valueOf(number
					.charAt(number.length() - i))) + (isAdding ? 1 : 0);

			if (digitTotal >= 10) {
				digitTotal -= 10;
				isAdding = true;
			} else {
				isAdding = false;
			}

			subTotal.insert(0, digitTotal);
		}

		return isAdding ? "1" + subTotal.toString() : subTotal.toString();
	}
}

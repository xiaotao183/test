package tao.xiao;

public class JustifyText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		print(new JustifyText().format(new String[] {"bob", "tommy", "jim"}));
		print(new JustifyText().format(new String[] {"johm", "jake", "alan", "blue"}));
		print(new JustifyText().format(new String[] {"longest", "a", "longer", "short"}));
	}
	
	private static void print(String[] text) {
		for (String string : text) {
			System.out.print(string + "|" + string.length() + ",");
		}
		System.out.println();
	}

	public String[] format(String[] text) {
		int maxLength = getMaxStringLength(text);
		String[] justifiedText = new String[text.length];

		for (int i = 0; i < text.length; i++) {
			justifiedText[i] = getPaddedString(text[i], maxLength);
		}

		return justifiedText;
	}

	private int getMaxStringLength(String[] text) {
		int maxSize = 0;

		for (String string : text) {
			maxSize = Math.max(maxSize, string.length());
		}

		return maxSize;
	}

	private String getPaddedString(String string, int maxLength) {
		int lengthDiff = maxLength - string.length();

		if (lengthDiff == 0) {
			return string;
		} else {
			StringBuilder stringBuilder = new StringBuilder(string);
			for (int i = 0; i < lengthDiff; i++) {
				stringBuilder.insert(0, " ");
			}

			return stringBuilder.toString();
		}
	}
}

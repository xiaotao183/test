package tao.xiao;

public class KMPSearch {
	public static void main(String[] args) {
		System.out.println(new KMPSearch().match("ABC ABCDAB ABCDABCDABDE", "DDD"));
		System.out.println("ABC ABCDAB ABCDABCDABDE".indexOf("ABCDABD"));
		// new KMPSearch().buildVektor("abcabad");
		//
		// System.out.println(new KMPSearch().match("AAAAAAAAAAAAAAAAAAAAAAAAB",
		// "AAB"));

	}

	public int match(String string, String pattern) {
		int[] partialTable = buildPartialTable(pattern);
		int patternIndex = 0;

		for (int i = 0; i < string.length(); i++) {
			while (patternIndex > 0
					&& string.charAt(i) != pattern.charAt(patternIndex)) {
				patternIndex = partialTable[patternIndex];
			}

			if (string.charAt(i) == pattern.charAt(patternIndex)) {
				patternIndex++;
			}

			if (patternIndex == pattern.length()) {
				return i - pattern.length() + 1;
			}
		}

		return -1;
	}

	private int[] buildPartialTable(String pattern) {
		int[] partialTable = new int[pattern.length()];
		partialTable[0] = 0;
		partialTable[1] = 0;
		int previousMatch = partialTable[1];

		for (int i = 2; i < partialTable.length; i++) {
			while (previousMatch > 0
					&& pattern.charAt(previousMatch) != pattern.charAt(i - 1)) {
				previousMatch = partialTable[previousMatch];
			}

			if (pattern.charAt(previousMatch) == pattern.charAt(i - 1)) {
				previousMatch++;
			}

			partialTable[i] = previousMatch;
		}

		return partialTable;
	}
}

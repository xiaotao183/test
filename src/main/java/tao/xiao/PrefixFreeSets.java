package tao.xiao;

import java.util.Arrays;

public class PrefixFreeSets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new PrefixFreeSets().maxElements(new String[] {
				"hello", "hi", "h", "run", "return", "running" }));

		System.out.println(new PrefixFreeSets().maxElements(new String[] { "a",
				"b", "cba", "cbc", "cbb", "ccc" }));

		System.out.println(new PrefixFreeSets().maxElements(new String[] { "a",
				"ab", "abc", "abcd", "abcde", "abcdef" }));

		System.out.println(new PrefixFreeSets().maxElements(new String[] {
				"topcoder", "topcoder", "topcoding" }));

	}

	public int maxElements(String[] words) {
		int max = 0;

		if (words.length < 2) {
			max = words.length;
		} else {
			Arrays.sort(words);

			for (int i = 0; i < words.length - 1; i++) {
				if (!words[i + 1].startsWith(words[i])) {
					max++;
				}
			}

			max++;
		}

		return max;
	}
}

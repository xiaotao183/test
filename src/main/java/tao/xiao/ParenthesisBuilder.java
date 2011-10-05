package tao.xiao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ParenthesisBuilder {
	private static final String PAIR_OF_PARENTHESIS = "()";

	private Set<String> parenthesisSet;

	public static void main(String[] args) {
		// System.out.println(new ParenthesisBuilder().build(3));

		try {
			throw new NullPointerException();
		} catch (NullPointerException ee) {
			System.out.println("c1");
			throw ee;
		} catch (Exception e) {
			System.out.println("c");
		} finally {

			System.out.println("test");
		}
	}

	public String build(int numberOfParenthesis) {
		parenthesisSet = build(numberOfParenthesis, parenthesisSet);

		StringBuilder stringBuilder = new StringBuilder();
		if (parenthesisSet != null) {
			for (String parenthsisPairs : parenthesisSet) {
				stringBuilder.append(parenthsisPairs).append(" ");
			}
		}

		return stringBuilder.toString();
	}

	private Set<String> build(int numberOfParenthesis,
			Set<String> parenthesisSet) {
		if (numberOfParenthesis > 1) {
			parenthesisSet = build(numberOfParenthesis - 1, parenthesisSet);
		}

		if (numberOfParenthesis > 0) {
			parenthesisSet = buildANewPair(parenthesisSet);
		}

		return parenthesisSet;
	}

	private Set<String> buildANewPair(Set<String> parenthesisSet) {
		Set<String> newParenthesisSet = new HashSet<String>();

		if (parenthesisSet == null) {
			newParenthesisSet.add(PAIR_OF_PARENTHESIS);
		} else {
			Iterator<String> iter = parenthesisSet.iterator();
			while (iter.hasNext()) {
				String parenthesisPairs = iter.next();

				for (int i = 1; i <= parenthesisPairs.length(); i++) {
					StringBuilder stringBuilder = new StringBuilder(
							parenthesisPairs);
					stringBuilder.insert(i, PAIR_OF_PARENTHESIS);
					newParenthesisSet.add(stringBuilder.toString());
				}
			}
		}

		return newParenthesisSet;
	}
}

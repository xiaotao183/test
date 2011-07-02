package tao.xiao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PermutationSum {
	private Set<String> permutations;
	private List<String> digits;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new PermutationSum().add(157));
		System.out.println(new PermutationSum().add(313));
		System.out.println(new PermutationSum().add(1234));
		System.out.println(new PermutationSum().add(5));
		System.out.println(new PermutationSum().add(54321));
		System.out.println(new PermutationSum().add(99999));
	}

	public int add(int n) {
		constructDigitsList(n);
		permutations = build(digits.size(), permutations);
		
		return sum(permutations);
	}

	private void constructDigitsList(int n) {
		digits = new ArrayList<String>();
		String numberStirng = String.valueOf(n);

		for (int i = 0; i < numberStirng.length(); i++) {
			digits.add(String.valueOf(numberStirng.charAt(i)));
		}
	}

	private Set<String> build(int length, Set<String> permutations) {
		if (length > 1) {
			permutations = build(length - 1, permutations);
		}

		if (length > 0) {
			permutations = buildNewDigit(length - 1, permutations);
		}

		return permutations;
	}

	private Set<String> buildNewDigit(int index, Set<String> permutations) {
		String digit = digits.get(index);
		Set<String> newPermutations = new HashSet<String>();

		if (permutations == null) {
			newPermutations.add(digit);
		} else {
			Iterator<String> iter = permutations.iterator();
			while (iter.hasNext()) {
				String permutation = new String(iter.next());
				for (int i = 0; i <= permutation.length(); i++) {
					StringBuilder newPermutation = new StringBuilder(permutation);
					newPermutation.insert(i, digit);
					newPermutations.add(newPermutation.toString());
				}
			}
		}

		return newPermutations;
	}
	
	private int sum(Set<String> permutations) {
		int sum = 0;
		
		for (String permutation : permutations) {
			sum += Integer.valueOf(permutation);
		}
		
		return sum;
	}
}

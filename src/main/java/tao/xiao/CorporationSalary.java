package tao.xiao;

public class CorporationSalary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new CorporationSalary().totalSalary(new String[] {
				"NNNNNN", "YNYNNY", "YNNNNY", "NNNNNN", "YNYNNN", "YNNYNN" }));

		System.out.println(new CorporationSalary().totalSalary(new String[] {
				"NYNNYN", "NNNNNN", "NNNNNN", "NNYNNN", "NNNNNN", "NNNYYN" }));

		System.out.println(new CorporationSalary().totalSalary(new String[] {
				"NNNN", "NNNN", "NNNN", "NNNN" }));

		System.out.println(new CorporationSalary().totalSalary(new String[] {
				"NNYN", "NNYN", "NNNN", "NYYN" }));
	}

	public long totalSalary(String[] relations) {
		long sum = 0;

		for (int i = 0; i < relations.length; i++) {
			sum += totalSalary(relations, i);
		}

		return sum;
	}

	private long totalSalary(String[] relations, int index) {
		String relation = relations[index];
		long sum = 0;

		if (!relation.contains("Y")) {
			return 1;
		}

		for (int i = 0; i < relation.length(); i++) {
			if ('Y' == relation.charAt(i)) {
				sum += totalSalary(relations, i);
			}
		}

		return sum;
	}
}

package tao.xiao;

public class LeaguePicks {
	public static void main(String[] args) {
		printArray(returnPicks(5, 11, 100));
		System.out.println();
		printArray(returnPicks(1, 2, 39));
		System.out.println();
		printArray(returnPicks(1, 1, 10));
		System.out.println();
		printArray(returnPicks(3, 6, 15));
		System.out.println();
		printArray(returnPicks(5, 11, 1));
		System.out.println();
		printArray(returnPicks(5, 19, 100));
	}
	
	public static void printArray(int[] array) {
		if (array != null) {
			for (Integer i : array) {
				System.out.print(i + ",");
			}
		}else {
			System.out.print("no pick");
		}
	}

	public static int[] returnPicks(int position, int friends, int picks) {
		int size = getSize(position, friends, picks);
		int current = 0;

		if (size == 0) {
			return null;
		} else {
			int[] positions = new int[size];

			for (int i = 0; i < size; i++) {
				if (i % 2 == 0) {
					current = direct(position, friends, i);
				} else {
					current = inverse(current, position, friends);
				}

				positions[i] = current;
			}

			return positions;
		}
	}

	private static int getSize(int position, int friends, int picks) {
		int nth = picks / friends;

		if (nth % 2 == 0) {
			return picks % friends >= position ? nth + 1 : nth;
		} else {
			return picks % friends > friends - position ? nth + 1 : nth;
		}
	}

	private static int direct(int initial, int friends, int nth) {
		return initial + nth * friends;
	}

	private static int inverse(int current, int initial, int friends) {
		return current + 2 * (friends - initial) + 1;
	}
}

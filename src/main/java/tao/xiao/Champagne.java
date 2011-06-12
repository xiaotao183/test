package tao.xiao;

import org.apache.commons.math.util.MathUtils;

public class Champagne {
	private int units;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Champagne().howMuch(20, 204, 299));
	}

	public String howMuch(int height, int glass, int units) {
		int glassHeight = getGlassHeight(glass);
		this.units = units;
		int denomenator = (int) Math.pow(2, glassHeight - 1);
		int unitInGlass = unitInGlass(glass, glassHeight, denomenator);
		int gcd = MathUtils.gcd(unitInGlass, denomenator * 2);

		return String.valueOf(unitInGlass / gcd) + "/"
				+ (unitInGlass != 0 ? (denomenator * 2) / gcd : 1);
	}

	private int getGlassHeight(int glass) {
		int height = 1;

		while (true) {
			int currentMinGlass = getHeightMinGlass(height);
			int currentMaxGlass = getHeightMaxGlass(height);

			if (currentMinGlass <= glass && glass <= currentMaxGlass) {
				return height;
			} else {
				height++;
			}
		}
	}

	private int getHeightMaxGlass(int height) {
		int currentMaxGlass = (1 + height) * height / 2;
		return currentMaxGlass;
	}

	private int getHeightMinGlass(int height) {
		int currentMinGlass = height * (height - 1) / 2 + 1;
		return currentMinGlass;
	}

	private int unitInGlass(int glass, int glassHeight, int denomenator) {
		int currentMinGlass = getHeightMinGlass(glassHeight);
		int currentMaxGlass = getHeightMaxGlass(glassHeight);
		int leftParent = glass - glassHeight;
		int rightParent = glass - glassHeight + 1;
		int leftParentUnit = 0;
		int rightParentUnit = 0;

		if (glass == 1) {
			return units;
		} else if (glass == currentMinGlass) {
			rightParentUnit = unitInGlass(rightParent, glassHeight - 1,
					denomenator / 2) - denomenator;
		} else if (glass == currentMaxGlass) {
			leftParentUnit = unitInGlass(leftParent, glassHeight - 1,
					denomenator / 2) - denomenator;
		} else {
			rightParentUnit = unitInGlass(rightParent, glassHeight - 1,
					denomenator / 2) - denomenator;
			leftParentUnit = unitInGlass(leftParent, glassHeight - 1,
					denomenator / 2) - denomenator;
		}

		if (leftParentUnit < 0) {
			leftParentUnit = 0;
		}

		if (rightParentUnit < 0) {
			rightParentUnit = 0;
		}

		return leftParentUnit + rightParentUnit;
	}

	// private BigDecimal unitInGlass(int glass, int glassHeight) {
	// int currentMinGlass = getHeightMinGlass(glassHeight);
	// int currentMaxGlass = getHeightMaxGlass(glassHeight);
	// int leftParent = glass - glassHeight;
	// int rightParent = glass - glassHeight + 1;
	// BigDecimal leftParentUnit = null;
	// BigDecimal rightParentUnit = null;
	//
	// if (glass == 1) {
	// return BigDecimal.valueOf(units);
	// } else if (glass == currentMinGlass) {
	// rightParentUnit = unitInGlass(rightParent, glassHeight - 1)
	// .subtract(BigDecimal.valueOf(2));
	// } else if (glass == currentMaxGlass) {
	// leftParentUnit = unitInGlass(leftParent, glassHeight - 1).subtract(
	// BigDecimal.valueOf(2));
	// } else {
	// leftParentUnit = unitInGlass(leftParent, glassHeight - 1).subtract(
	// BigDecimal.valueOf(2));
	// rightParentUnit = unitInGlass(rightParent, glassHeight - 1)
	// .subtract(BigDecimal.valueOf(2));
	// }
	//
	// if (leftParentUnit != null
	// && leftParentUnit.compareTo(BigDecimal.valueOf(0)) == 1) {
	// leftParentUnit = leftParentUnit.divide(BigDecimal.valueOf(2));
	// } else {
	// leftParentUnit = BigDecimal.valueOf(0);
	// }
	//
	// if (rightParentUnit != null
	// && rightParentUnit.compareTo(BigDecimal.valueOf(0)) == 1) {
	// rightParentUnit = rightParentUnit.divide(BigDecimal.valueOf(2));
	// } else {
	// rightParentUnit = BigDecimal.valueOf(0);
	// }
	//
	// return leftParentUnit.add(rightParentUnit);
	// }
}

package tao.xiao;

import org.apache.commons.math.util.MathUtils;

public class AllButOneDivisor {
	public static void main(String[] args) {
		System.out.println(new AllButOneDivisor().getMinimum(new int[] {2, 3, 5}));
		System.out.println(new AllButOneDivisor().getMinimum(new int[] {2, 3, 4, 9}));
		System.out.println(new AllButOneDivisor().getMinimum(new int[] {2, 3, 6}));
		System.out.println(new AllButOneDivisor().getMinimum(new int[] {6, 7, 8, 9, 10}));
		System.out.println(new AllButOneDivisor().getMinimum(new int[] {10, 6, 15}));
	}
	
	public int getMinimum(int[] divisors) {
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < divisors.length; i ++) {
			int lcm = 1;
			
			for (int j = 0; j < divisors.length; j ++) {
				if (j != i) {
					lcm = MathUtils.lcm(lcm, divisors[j]);
				}
			}
			
			if (lcm % divisors[i] != 0 && lcm < min) {
				min = lcm;
			}
		}
		
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		
		return min;
	}
}

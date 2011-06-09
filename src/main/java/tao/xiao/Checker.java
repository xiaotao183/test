package tao.xiao;

import tao.xiao.validation.LoversElementValidator;
import tao.xiao.validation.LoversSizeValidator;
import tao.xiao.validation.Validator;

public class Checker {
	public static void main(String[] args) {
		System.out.println(new Checker().CheckData(new String[] {
				"D-G LOVES M", "M LOVES D-G", "T LOVES G", "G LOVES D-G" }));

		System.out.println(new Checker().CheckData(new String[] { "D LOVES M",
				"D LOVES C", "G LOVES M", "M LOVES T", "T LOVES D" }));

		System.out.println(new Checker().CheckData(new String[] { "N LOVES C",
				"C LOVES D", "D LOVES M", "M LOVES g", "g LOVES N" }));

		System.out.println(new Checker().CheckData(new String[] { "A LOVES B",
				"A LOVES C", "C LOVES A", "B  LOVES A" }));

		System.out.println(new Checker()
				.CheckData(new String[] { "ME LOVES YOU" }));

		System.out.println(new Checker().CheckData(new String[] {
				"ME LOVES YOU", "ME LOVES YOU", "YOU LOVES ME" }));

		System.out.println(new Checker().CheckData(new String[] { "I LOVE YOU",
				"YOU LOVE I" }));
	}

	public boolean CheckData(String[] lovers) {
		return validateLovers(lovers, new LoversSizeValidator(),
				new LoversElementValidator());
	}

	private boolean validateLovers(String[] lovers, Validator... validators) {
		for (Validator validator : validators) {
			if (!validator.validate(lovers)) {
				return false;
			}
		}

		return true;
	}
}

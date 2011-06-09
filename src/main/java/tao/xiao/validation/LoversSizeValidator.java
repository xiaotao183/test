package tao.xiao.validation;

public class LoversSizeValidator implements Validator {
	private static final int MIN_SIZE = 2;
	private static final int MAX_SIZE = 20;

	public boolean validate(String[] input) {
		return input != null && input.length >= MIN_SIZE
				&& input.length <= MAX_SIZE;
	}

}

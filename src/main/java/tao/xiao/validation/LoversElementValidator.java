package tao.xiao.validation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class LoversElementValidator implements Validator {
	private final static int ELEMENT_SIZE = 40;
	private final static String REGEX = "([A-Z]|-)+ LOVES ([A-Z]|-)+";

	private HashSet<String> name1s = new HashSet<String>();
	private HashSet<String> name2s = new HashSet<String>();

	public boolean validate(String[] input) {
		for (String element : input) {
			if (StringUtils.isEmpty(element)) {
				return false;
			}

			if (element.length() > ELEMENT_SIZE) {
				return false;
			}

			if (!Pattern.matches(REGEX, element)) {
				return false;
			}

			String[] names = element.split(" LOVES ");
			if (names[0].equals(names[1])) {
				return false;
			}

			name1s.add(names[0]);
			name2s.add(names[1]);
		}

		Iterator<String> iterator = name2s.iterator();
		
		while (iterator.hasNext()) {
			if (!name1s.contains(iterator.next())) {
				return false;
			}
		}

		return true;
	}
}

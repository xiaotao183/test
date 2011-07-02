package tao.xiao;

import org.apache.commons.lang.StringUtils;

public class SignatureDecorator {
	public static void main(String[] args) {
		System.out.println(new SignatureDecorator().applyDecoration("Bob",
				new String[] { "surround", "append", "prepend" }, new String[] {
						"-=", "{", "}" }));
	}

	public String applyDecoration(String name, String[] commands,
			String[] decorations) {
		StringBuilder builder = new StringBuilder(name);

		for (int i = 0; i < commands.length; i++) {
			if ("prepend".equals(commands[i])) {
				builder.insert(0, decorations[i]);
			} else if ("append".equals(commands[i])) {
				builder.append(decorations[i]);
			} else {
				builder.insert(0, decorations[i]).append(
						StringUtils.reverse(decorations[i]));
			}
		}

		return builder.toString();
	}
}

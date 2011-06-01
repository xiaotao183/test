package tao.xiao;

public class BinaryCode {
	public static void main(String[] args) {
		String[] decoded = new BinaryCode().decode(new String[] {"1", "2", "2", "2", "1", "1", "1", 
				"2", "2", "2", "2", "2", "2", "1", "1", "1", "2", "2", "2", "1", "1", "1", "1", "1", 
				"1", "1", "1", "1", "2", "2", "2", "1", "1", "1", "1"});

		for (String bit : decoded) {
			System.out.print(bit + ",");
		}
	}

	public String[] decode(String[] message) {
		String[] decodedMessage = new String[message.length];
		decodeBit(decodedMessage, message, message.length - 1, "1");

		return decodedMessage;
	}

	private String decodeBit(String[] input, String[] message,
			int messageIndex, String startValue) {
		if (messageIndex == 0) {
			input[0] = startValue;
		} else if (messageIndex == 1) {
			input[1] = String.valueOf(Integer.valueOf(message[0])
					- Integer.valueOf(decodeBit(input, message,
							messageIndex - 1, startValue)));
		} else {
			input[messageIndex] = String.valueOf(Integer
					.valueOf(message[messageIndex - 1])
					- Integer.valueOf(decodeBit(input, message,
							messageIndex - 1, startValue))
					- Integer.valueOf(decodeBit(input, message,
							messageIndex - 2, startValue)));
		}

		if (Integer.valueOf(input[messageIndex]) > 1) {
			throw new IllegalStateException(String.valueOf(messageIndex));
		} else {
			return input[messageIndex];
		}
	}
}

package tao.xiao;

public class Time {
	private static final int SECONDS_PER_MINUTE = 60;
	private static final int SECONDS_PER_HOUR = 60 * SECONDS_PER_MINUTE;

	public static void main(String[] args) {
		System.out.println(new Time().whatTime(0));
		System.out.println(new Time().whatTime(3661));
		System.out.println(new Time().whatTime(5436));
		System.out.println(new Time().whatTime(86399));
	}

	public String whatTime(int seconds) {
		int hour = seconds / SECONDS_PER_HOUR;
		seconds = seconds - hour * SECONDS_PER_HOUR;

		int minute = seconds / SECONDS_PER_MINUTE;
		seconds = seconds - minute * SECONDS_PER_MINUTE;

		return hour + ":" + minute + ":" + seconds;
	}
}

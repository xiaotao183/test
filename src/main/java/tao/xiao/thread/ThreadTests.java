package tao.xiao.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadTests {

	// Parallel arrays used in the conversion process.
	private static final String[] RCODE = { "M", "CM", "D", "CD", "C", "XC",
			"L", "XL", "X", "IX", "V", "IV", "I" };
	private static final int[] BVAL = { 1000, 900, 500, 400, 100, 90, 50, 40,
			10, 9, 5, 4, 1 };

	public static int I = 0;

	// =========================================================== binaryToRoman
	public static String binaryToRoman(int binary) {
		if (binary <= 0 || binary >= 4000) {
			throw new NumberFormatException(
					"Value outside roman numeral range.");
		}
		String roman = ""; // Roman notation will be accumualated here.

		// Loop from biggest value to smallest, successively subtracting,
		// from the binary value while adding to the roman representation.
		for (int i = 0; i < RCODE.length; i++) {
			while (binary >= BVAL[i]) {
				binary -= BVAL[i];
				roman += RCODE[i];
			}
		}
		return roman;
	}

	class T1 implements Runnable {
		private AnotherResource resource;
		private volatile boolean cancel = false;

		public T1(AnotherResource resource) {
			this.resource = resource;
		}

		public void run() {
			while (!cancel) {
				System.out.println("--in--");
			}

			System.out.println("--out--");
		}

		public void cancel() {
			this.cancel = true;
		}

	}

	class T2 implements Runnable {
		private AnotherResource resource;

		public T2(AnotherResource resource) {
			this.resource = resource;
		}

		public void run() {
			resource.ia();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		// AnotherResource anotherResource = new AnotherResource();
		// ThreadTests tests = new ThreadTests();
		// ThreadTests.T1 t1 = tests.new T1(anotherResource);
		//
		// ExecutorService es = Executors.newCachedThreadPool();
		// es.execute(t1);
		//
		// es.shutdown();
		//
		// TimeUnit.SECONDS.sleep(1);
		//
		// t1.cancel();
		// System.out.println("--cancel");

		System.out.println(getCount());
		System.out.println(I);
	}

	public static int getCount() {
		return I++;
	}
}
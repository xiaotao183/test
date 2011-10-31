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
		private final ChocolateBoiler resource;

		public T1(ChocolateBoiler resource) {
			this.resource = resource;
		}

		@Override
		public void run() {
			System.out.println("--run boil");
			resource.boil();
			System.out.println("boil done");
		}

	}

	class T2 implements Runnable {
		private final ChocolateBoiler resource;

		public T2(ChocolateBoiler resource) {
			this.resource = resource;
		}

		@Override
		public void run() {
			System.out.println("--run drain");
			resource.drain();
			System.out.println("drain done");
		}

	}

	public static void main(String[] args) throws InterruptedException {
		 ChocolateBoiler boiler = ChocolateBoiler.getInstance();
		 ThreadTests tests = new ThreadTests();
		 ThreadTests.T1 t1 = tests.new T1(boiler);
		 ThreadTests.T2 t2 = tests.new T2(boiler);
		
		 ExecutorService es = Executors.newCachedThreadPool();
		 es.execute(t1);
		 es.execute(t2);
		
		 es.shutdown();
		
		 TimeUnit.SECONDS.sleep(100);
	}

	public static int getCount() {
		return I++;
	}
}
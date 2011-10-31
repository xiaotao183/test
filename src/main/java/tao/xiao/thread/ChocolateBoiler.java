package tao.xiao.thread;

import java.util.concurrent.TimeUnit;
 
public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	private static ChocolateBoiler uniqueInstance;
  
	private ChocolateBoiler() {
		empty = false;
		boiled = false;
	}
  
	public static ChocolateBoiler getInstance() {
		if (uniqueInstance == null) {
			System.out.println("Creating unique instance of Chocolate Boiler");
			uniqueInstance = new ChocolateBoiler();
		}
		System.out.println("Returning instance of Chocolate Boiler");
		return uniqueInstance;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
			// fill the boiler with a milk/chocolate mixture
		}
	}
 
	public void drain() {
			System.out.println("drain in");
		if (!isEmpty() && isBoiled()) {
			System.out.println("drain in in");
			// drain the boiled milk and chocolate
			empty = true;
		}
	}
 
	public void boil() {
		System.out.println("boil in");
		if (!isEmpty() && !isBoiled()) {
			System.out.println("---+++444444");
			try {
				System.out.println("------++++" + isEmpty());
				TimeUnit.SECONDS.sleep(5);
				System.out.println("------" + isEmpty());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("boil in ini");
			// bring the contents to a boil
			boiled = true;
		}
		
		System.out.println("---+++44444455555");
	}
  
	public boolean isEmpty() {
		return empty;
	}
 
	public boolean isBoiled() {
		return boiled;
	}
}

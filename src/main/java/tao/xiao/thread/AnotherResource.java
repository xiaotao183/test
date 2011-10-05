package tao.xiao.thread;

public class AnotherResource {
	public static String r = "t";
	
	public static void test1() {
		
	}
	
	public synchronized void invokeI() throws InterruptedException {
		Thread.sleep(10000);
	}

	public synchronized void ia() {
		System.out.println("test");
	}
}

package tao.xiao.thread;

public class Resource  extends AnotherResource {
	public static String r = "a";
	
	private AnotherResource anotherResource = new AnotherResource();

	public static void test1() {
		
	}
	
	public void invokeI() throws InterruptedException {
		synchronized (this) {
			this.wait();
		}
	}
	
	public void invokeIa() throws InterruptedException {
		synchronized (anotherResource) {
			anotherResource.wait();
		}
	}

	public void ia() {
		synchronized (this) {
			notifyAll();
		}
	}
	
	public void ia2() {
		synchronized (anotherResource) {
			anotherResource.notifyAll();
		}
	}
}



// Thread's run method gets preference over Runnable run
public class Test {

	public static void main(String[] args) {
		//new MyThread().start();
		new MyThread(new MyRunnable()).start();
	}

}

class MyThread extends Thread{
	MyThread(){}
	MyThread(Runnable r){
		super(r);
	}
	
	/*//@Override
	public void run() {
		System.out.println("Inside Thread");
	}*/
	

}

class MyRunnable implements Runnable{
	
	public void run() {
		System.out.println("Inside Runnable");
	}
	
}

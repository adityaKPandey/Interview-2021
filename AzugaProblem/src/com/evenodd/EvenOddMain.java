package com.evenodd;

public class EvenOddMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Object lock = new Object();
		EvenThread evenThread = new EvenThread(lock);
		OddThread oddThread = new OddThread(lock);
		
		Thread t1 = new Thread(oddThread);
		Thread t2 = new Thread(evenThread);
		
		t1.start();
		Thread.sleep(1);
		t2.start();
		
		t1.join();
		t2.join();
	}

}

package com.broadcom;

public class DeadlockCreation {

	public DeadlockCreation() {
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Object object1 = new Object();
		Object object2 = new Object();
		
		Worker task1 = new Worker(object1, object2);
		
		Worker2 task2 = new Worker2(object1, object2);
		
		Thread thread1 = new Thread(task1);
		
		Thread thread2 = new Thread(task2);
		
		thread1.start();
		//Thread.currentThread().sleep(4000);
		thread2.start();
	}

}

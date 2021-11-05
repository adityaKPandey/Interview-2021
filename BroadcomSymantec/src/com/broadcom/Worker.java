package com.broadcom;

public class Worker implements Runnable {

	private Object lockA;
	private Object lockB;

	public Worker(Object object1 , Object object2) {
		// TODO Auto-generated constructor stub

		this.lockA = object1;
		this.lockB = object2;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			synchronized(lockA) {

				System.out.println("1. Acquired lockA");

				//Thread.currentThread().sleep(4000);
				lockA.wait();
				
			}
			
			System.out.println("Done with lock A");
			synchronized(lockB) {

				System.out.println("1 . Acquired lockB");
			}

			System.out.println("1 . Done");
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}

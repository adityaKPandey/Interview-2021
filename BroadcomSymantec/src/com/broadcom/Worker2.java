package com.broadcom;

public class Worker2 implements Runnable {

	private Object lockA;
	private Object lockB;
	
	public Worker2(Object object1 , Object object2) {
		// TODO Auto-generated constructor stub
		
		this.lockA = object1;
		this.lockB = object2;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
		synchronized(lockB) {
			
			System.out.println("2 . Acquired lockB");
			//Thread.currentThread().sleep(000);
			 lockB.wait();
			
		}
		
		System.out.println("Done with lock B");
		 synchronized(lockA) {
			 
			 System.out.println("2 . Acquired lockA");
			 lockA.notify();
		 }
		 
		 System.out.println("2. Done");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

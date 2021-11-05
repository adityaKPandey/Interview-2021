package com.evenodd;

public class EvenThread implements Runnable {

	private Object lock;
	private int num = 1;

	public EvenThread(Object lock) {
		this.lock = lock;
	}


	@Override
	public void run() {
	
		synchronized(lock) {
			while(num < 11) {
				num++;
			if(num%2 == 0) {
				System.out.print("E:"+num + " ");
				
				lock.notify();
			}else {
				
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			}
		}

		

	}

}

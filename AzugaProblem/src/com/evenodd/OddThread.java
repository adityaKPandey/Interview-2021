package com.evenodd;

public class OddThread implements Runnable {

	private Object lock;
	private int num = 0;

	public OddThread(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		synchronized(lock) {
			while(num < 10) {
				num++;
				if(num%2 == 1) {
					System.out.print("O:"+num + " ");
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

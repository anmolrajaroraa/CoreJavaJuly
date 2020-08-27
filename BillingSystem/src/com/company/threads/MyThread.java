package com.company.threads;

public class MyThread extends Thread implements Runnable{
	int x;
	
	public MyThread(String name, int waitTime) {
		super(name);
		x = waitTime;
	}
	@Override
	public void run() {
		System.out.println("MyThread - START " + Thread.currentThread().getName());
		try {
//			Thread.sleep(1000);
			long startTime = System.currentTimeMillis();
			doDBProcessing();
			System.out.println("MyThread - END " + Thread.currentThread().getName());
			System.out.println("Total time taken by thread in ms - " + 
					(System.currentTimeMillis() - startTime) );
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void doDBProcessing() throws InterruptedException {
//		for(int i = 31; i < 255; i++) {
//			System.out.println( (char)i );
			Thread.sleep(2000);
//		}
	}
}

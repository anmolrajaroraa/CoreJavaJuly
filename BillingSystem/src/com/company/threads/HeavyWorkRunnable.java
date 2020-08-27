package com.company.threads;

public class HeavyWorkRunnable implements Runnable{
	
	int x;
	
	public HeavyWorkRunnable(int waitTime) {
		x = waitTime;
	}

	@Override
	public void run() {
		System.out.println("Doing heavy processing - START " + Thread.currentThread().getName());
		try {
			String s = "iujkl";
			s.notify();
//			Thread.sleep(1000);
			long startTime = System.currentTimeMillis();
			doDBProcessing();
			System.out.println("Doing heavy processing - END " + Thread.currentThread().getName());
			System.out.println("Total time taken by thread in ms - " + 
					(System.currentTimeMillis() - startTime) );
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void doDBProcessing() throws InterruptedException {
//		Thread.sleep(5000);
//		for(int i = 0; i<1000; i++) {
//			System.out.println(i);
		Thread.sleep(10000);
		String s = "iujkl";
		s.notify();
//		}
	}

}

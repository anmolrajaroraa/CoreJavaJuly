package com.company.threads;

public class ThreadRunExample {

	public static void main(String[] args) throws InterruptedException {
//		Thread t1 = new Thread(new HeavyWorkRunnable(10), "t1");
//		Thread t2 = new Thread(new HeavyWorkRunnable(5), "t2");
//		Thread t3 = new Thread(new HeavyWorkRunnable(2), "t3");
//		Thread t4 = new Thread(new HeavyWorkRunnable(1), "t4");
//		System.out.println("Starting Runnable threads");
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		System.out.println("Runnable threads have been started");
//		Thread t5 = new MyThread("t5", 10);
//		Thread t6 = new MyThread("t6", 5);
//		Thread t7 = new MyThread("t7", 2);
//		Thread t8 = new MyThread("t8", 1);
//		System.out.println("Starting MyThreads");
//		t5.start();
//		t6.start();
//		t7.start();
//		t8.start();
//		System.out.println("MyThreads have been started");
		
		Thread t1 = new Thread(new HeavyWorkRunnable(10), "t1");
		Thread t2 = new Thread(new HeavyWorkRunnable(10), "t2");
		t1.start();
//		t1.join(2000);
		t2.start();
	}

}

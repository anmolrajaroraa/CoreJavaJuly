package com.company.threads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ProcessingThread implements Runnable{

	private int count;
	private Object fake = new Object();
	
	public int getCount() {
		return count;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " started at " + System.currentTimeMillis());
		for(int i=1; i<5; i++) {
			processSomething(i);
			
//			synchronized (fake) {
				count++;
				System.out.println(name + " currently has the lock for fake object");
				System.out.println("Updated value for count is " + count);
//			}
		}
		System.out.println(name + " finished at " + System.currentTimeMillis());
	}
	
	private void processSomething(int i) {
		try {
			Thread.sleep(1000*i);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

public class ThreadSafety {

	public static void main(String[] args) throws InterruptedException {
//		ProcessingThread pt = new ProcessingThread();
//		Thread t1 = new Thread(pt, "t1");
//		Thread t2 = new Thread(pt, "t2");
//		Thread t3 = new Thread(pt, "t3");
//		Thread t4 = new Thread(pt, "t4");
//		Thread t5 = new Thread(pt, "t5");
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();
//		System.out.println("All threads started...");
//		t1.join();
//		t2.join();
//		t3.join();
//		t4.join();
//		t5.join();
//		System.out.println("Processing count= " + pt.getCount());
		
		String s = "ram@gmail.com";
//		System.out.println(s.matches("^[a-z0-9_-]+@[a-z0-9_-]+\\.[a-z]$"));
//		System.out.println(Pattern.matches("^[a-z0-9_-]+@[a-z0-9_-]+\\.[a-z]$", s));
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(s);
		System.out.println(matcher.find());
	}
}

//*
//**
//***
//****
//*****
//
//A
//AB
//ABC
//ABCD
//ABCDE
//
//
//$$$$*
//$$$***
//$$*****
//$*******
//*********
//
//
//    *
//   ***
//  *****
// *******
//*********
// *******
//  *****
//   ***
//    *
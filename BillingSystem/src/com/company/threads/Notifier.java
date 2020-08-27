package com.company.threads;

public class Notifier implements Runnable{

	private Message message;
	
	public Notifier(Message message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " started");
		
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized (message) {
			message.setMsg(name + " Notifier work done");
			message.notify();
//			message.notifyAll();
		}
	}
	
}

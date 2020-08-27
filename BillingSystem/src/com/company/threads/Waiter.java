package com.company.threads;

public class Waiter implements Runnable{

	private Message message;
	
	public Waiter(Message message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		
		synchronized (message) {
			System.out.println(name + " waiting to get notified at time: " + System.currentTimeMillis());
			try {
				message.wait(10000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " waiter thread got notified at time: " + System.currentTimeMillis());
			System.out.println(name + " processed: " + message.getMsg());
		}
	}
	
}

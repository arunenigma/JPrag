package org.apache.jpragmatic.threads;

class ThreadEx extends Thread {
	ThreadEx() {
		System.out.println(this);
		start();
	}
	
	ThreadEx(String threadName) {
		super(threadName); // initialize thread
		System.out.println(this);
		start();	
	}
	
	@Override
	public void run() {	
	}
}

public class ThreadExample {
	public static void main(String[] args) {
		new ThreadEx("thread1");
		new ThreadEx("thread2");
		new ThreadEx();
		new ThreadEx();
		try {
			Thread.currentThread();
			Thread.sleep(1000);	
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		new ThreadEx("Foo");
	}
}

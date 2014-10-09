package org.apache.jpragmatic.threads;

class RunnableThread implements Runnable {
	Thread runner;
	
	public RunnableThread() {
	}
	
	public RunnableThread(String threadName) {
		runner = new Thread(this, threadName);
		System.out.println(runner.getName());
		runner.start();	
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread());	
	}
}

public class RunnableThreadExample {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new RunnableThread(), "thread1");
		Thread thread2 = new Thread(new RunnableThread(), "thread2");
		thread1.start();
		thread2.start();
		try {
			Thread.currentThread();
			Thread.sleep(1000);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread());	
	}	
}



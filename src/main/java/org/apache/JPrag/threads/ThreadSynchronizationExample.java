package org.apache.JPrag.threads;

public class ThreadSynchronizationExample extends Thread {
	private static String[] tokens = "I believe I can fly; I believe I can touch the sky!".split(" ");
	

	public ThreadSynchronizationExample(String threadID) {
		super(threadID);
	}

	public static void main(String[] args) {
		ThreadSynchronizationExample t1 = new ThreadSynchronizationExample("t1");
		ThreadSynchronizationExample t2 = new ThreadSynchronizationExample("t2");
		t1.start();
		t2.start();
		boolean t1IsAlive = true;
		boolean t2IsAlive = true;
		do {
			if(t1IsAlive && !t1.isAlive()) {
				t1IsAlive = false;
				System.out.println("t1 is dead");	
			}
			
			if(t2IsAlive && !t2.isAlive()) {
				t2IsAlive = false;
				System.out.println("t2 is dead");
			}
		}
		while(t1IsAlive || t2IsAlive);
	}
	
	public void randomWait() {
		try {
			Thread.currentThread();
			long sleepTime = (long) (1000 * Math.random());
			Thread.sleep(sleepTime);
			System.out.printf("%s sleeping for %.4f seconds", Thread.currentThread().getName(), (float) sleepTime/1000);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	@Override
	public synchronized void run() {
		SynchronizedOutput.displayTokens(getName(), tokens);	
	}
}

class SynchronizedOutput {
	// without "synchronized" keywords both threads will try to read the tokens at the same time
	// and the printed tokens will be completely random
	// try running the program by removing both the "synchronized" keyword here and in the run method above.
	public static synchronized void displayTokens(String name, String[] tokens) {
		for(String token: tokens) {
			ThreadSynchronizationExample t = (ThreadSynchronizationExample) Thread.currentThread();
			t.randomWait();
			System.out.println(" ==> " + token);	
		}	
	}
}

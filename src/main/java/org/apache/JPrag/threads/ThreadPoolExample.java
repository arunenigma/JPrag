package org.apache.JPrag.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
	public static void main(String[] args) {
		// create a pool of 10 threads
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i=0; i<100; i++) {
			service.submit(new Task(i));
		}
	}
}

final class Task implements Runnable {
	private int taskID;
	
	Task(int taskID) {
		this.taskID = taskID;	
	}

	@Override
	public void run() {
		System.out.println("Task ID: " + this.taskID + " performed by " + Thread.currentThread().getName());
	}
}

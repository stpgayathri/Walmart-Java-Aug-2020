package com;

public class Counter {

	int count;

	private Object mutex = new Object();

	// public synchronized void increment() {
	public void increment() {

		// this.count++;
		synchronized (mutex) {

			System.out.println(
					String.format("Thread Name: %s, counter: %d", Thread.currentThread().getName(), this.count));
			int temp = this.count;
			temp++;

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.count = temp;
			System.out.println(String.format("Completed Thread Name: %s, counter: %d", Thread.currentThread().getName(),
					this.count));
		}

	}

	public  void decrement() {

		synchronized (mutex) {
			this.count--;
		}
		

	}

}

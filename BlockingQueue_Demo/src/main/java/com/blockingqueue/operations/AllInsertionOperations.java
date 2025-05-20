/**
 * 
 */
package com.blockingqueue.operations;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Aqeel
 */
public class AllInsertionOperations {

	/**
	 * @param args
	 */
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

	public static void main(String[] args) {

		Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					//producerWithOffer();
					//producerWithAdd();
					producerWithPut();
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		});


		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					consumer();
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		});

		producer.start();
		consumer.start();
	}

	private static void producerWithOffer() throws InterruptedException {

		int count = 1;

		while(true) {
			boolean result = queue.offer(count);
			System.out.println("Produced: " + count + " " + result);
			Thread.sleep(1000);
			count++;
		}
	}

	private static void producerWithAdd() throws InterruptedException {

		int count = 1;

		while(true) {
			queue.add(count);
			System.out.println("Produced: " + count);
			Thread.sleep(1000);
			count++;
		}
	}

	private static void producerWithPut() throws InterruptedException {

		int count = 1;

		while(true) {
			queue.put(count);
			System.out.println("Produced: " + count);
			Thread.sleep(1000);
			count++;
		}
	}

	private static void consumer() throws InterruptedException {
		while(true) {
			Thread.sleep(10000);
			int element = queue.take();
			System.out.println("Consumed: "+ element+"\n");
		}
	}

}


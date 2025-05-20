/**
 * 
 */
package com.blockingqueue.blockingqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Aqeel
 */
public class LinkedBlockingQueueImpl_02 {

	// Bounded LinkedBlockingQueue
	private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
	
	public static void main(String[] arg) {

		Thread producerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					producer();
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		});


		Thread consumerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					consumer();
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		});

		producerThread.start();
		consumerThread.start();
	}

	private static void producer() throws InterruptedException {
		Random randomNumber = new Random(200);

		while(true) {
			int element = randomNumber.nextInt();
			queue.put(element);
			System.out.println("Produced: " + element);
			Thread.sleep(1000);
		}
	}

	private static void consumer() throws InterruptedException {
		while(true) {
			Thread.sleep(5000);
			int element = queue.take();
			System.out.println("Consumed: "+ element+"\n");
		}
	}
}

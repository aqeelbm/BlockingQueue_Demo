/**
 * 
 */
package com.blockingqueue.blockingqueue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Aqeel
 */
public class ArrayBlockingQueueImpl {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	public static void main(String[] arg) {

		Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					producer();
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

	private static void producer() throws InterruptedException {
		Random randomNumber = new Random(200);

		int count = 1;

		while(count<=5) {
			int element = randomNumber.nextInt();
			queue.put(element);
			System.out.println("Produced: " + element);
			Thread.sleep(3000);
			count++;
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

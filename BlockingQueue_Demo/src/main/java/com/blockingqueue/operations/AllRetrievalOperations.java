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
public class AllRetrievalOperations {

	/**
	 * @param args
	 */
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

	public static void main(String[] args) {

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
					consumerWithPeek();
//					consumerWithRemove();
//					consumerWithPoll();
//					consumerWithTake();
//					consumerWithElement();
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		});

		producer.start();
		consumer.start();
	}


	private static void producer() throws InterruptedException {

		int count = 1;

		while(true) {
			Thread.sleep(1000);
			queue.put(count);
			System.out.println("Produced: " + count);

			count++;
		}
	}

	/*
	 * 
	 * */
	private static void consumerWithElement() throws InterruptedException {
		while(true) {
			Thread.sleep(200);
			int element = queue.element();
			System.out.println("Consumed: "+ element+"\n");
		}
	}

	/*
	 * 
	 * */
	private static void consumerWithPeek() throws InterruptedException {
		while(true) {
			Thread.sleep(200);
			int element = queue.peek();
			System.out.println("Consumed: "+ element+"\n");
		}
	}

	/*
	 * 
	 * */
	private static void consumerWithRemove() throws InterruptedException {
		while(true) {
			Thread.sleep(200);
			int element = queue.remove();
			System.out.println("Consumed: "+ element+"\n");
		}
	}


	/*
	 * 
	 * */
	private static void consumerWithPoll() throws InterruptedException {
		while(true) {
			Thread.sleep(200);
			int element = queue.poll();
			System.out.println("Consumed: "+ element+"\n");
		}
	}


	/*
	 * 
	 * */
	private static void consumerWithTake() throws InterruptedException {
		while(true) {
			Thread.sleep(200);
			int element = queue.take();
			System.out.println("Consumed: "+ element+"\n");
		}
	}
}


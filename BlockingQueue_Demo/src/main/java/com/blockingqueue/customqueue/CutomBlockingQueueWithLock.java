/**
 * 
 */
package com.blockingqueue.customqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Aqeel
 */
public class CutomBlockingQueueWithLock<T> {
 
	private  Queue<T> queue = new LinkedList<>();
	private int capacity;
	
	private Lock lock = new ReentrantLock();
	private Condition fullQueueCondition = lock.newCondition();
	
	public CutomBlockingQueueWithLock(int capacity) {
		this.capacity = capacity;
	}
	
	public synchronized void put(T element) throws InterruptedException {
		while(queue.size() == capacity) {
			wait();
		}
		
		queue.add(element);
		notify();
	}
	
	public synchronized T take() throws InterruptedException {
		while(queue.isEmpty()) {
			wait();
		}
		
		T element = queue.remove();
		notify();
		return element;
	}
	
	
	public static void main(String[] args) {
		CutomBlockingQueueWithLock<Integer> queue = new CutomBlockingQueueWithLock<>(2);
		
		Runnable producer = new Runnable() {
			Random randomNumber = new Random();

			@Override
			public void run() {
				try {
					while(true) {
						int element =randomNumber.nextInt();
						queue.put(element);
						System.out.println("Produced: "+element);
						Thread.sleep(1000);
					}
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}

		};
		
		Runnable consumer = new Runnable() {

			@Override
			public void run() {
				try {
					while(true) {
						int element = queue.take();
						System.out.println("Consumed: " +element);
						Thread.sleep(200);
					}
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}
			
		};
		
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(producer);
		
		producerThread.start();
		consumerThread.start();
	}

}

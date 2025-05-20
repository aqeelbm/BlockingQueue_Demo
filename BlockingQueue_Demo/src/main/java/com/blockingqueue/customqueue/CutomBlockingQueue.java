package com.blockingqueue.customqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author Aqeel
 */
public class CutomBlockingQueue<T> {
	
	private Queue<T> queue = new LinkedList();
	private int capacity;
	
	public CutomBlockingQueue(int capacity) {
		this.capacity = capacity;
	}
	
	public synchronized void put(T element) throws InterruptedException {
		while(queue.size() == capacity) {
			System.out.println("waiting to get free space");
			wait();
		}
		queue.add(element);
		notify();
	}
	
	public synchronized T take() throws InterruptedException {
		while(queue.isEmpty()) {
			System.out.println("waiting to get element");
			wait();
		}
		
		//return queue.poll();
		T element = queue.remove();
		notify();
		return element;
	}
	

	public static void main(String[] args) {
		
		CutomBlockingQueue<Integer> queue = new CutomBlockingQueue<>(2);
		
		Runnable producer = new Runnable() {
			Random randomNumber = new Random(); 
			
			@Override
			public void run() {
				
				try {
					while(true) {
						int element = randomNumber.nextInt(500);
						queue.put(element);
						System.out.println("Produced: "+element);
						
						/*
						 * here you can reduce the sleep time compared to consumer 
						 * to see the behavior.
						 * */
						Thread.sleep(2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		};
		
		
		Runnable consumer = new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true) {
						Integer element = queue.take();
						System.out.println("Consumed: "+element+"\n");
						
						/*
						 * here you can increase the sleep time compared to producer 
						 * to see the behavior.
						 * */
						Thread.sleep(500);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		};
		
		
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		
		producerThread.start();
		consumerThread.start();
	}

}

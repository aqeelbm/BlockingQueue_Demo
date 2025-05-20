/**
 * 
 */
package com.blockingqueue.operations;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Aqeel
 */
public class Test_Clear {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		System.out.println(queue);
		
		if(!queue.isEmpty()) {
			queue.clear();
		}

		System.out.println(queue);
		
	}

}

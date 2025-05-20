/**
 * 
 */
package com.blockingqueue.operations;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Aqeel
 */
public class AddAllExample {

	/**
	 * @param args
	 */

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

	public static void main(String[] args) throws InterruptedException {

		ArrayList<Integer> ArrLis
		= new ArrayList<Integer>();

		// Add number to ArrayList
		ArrLis.add(55);
		ArrLis.add(66);
		ArrLis.add(77);
		ArrLis.add(88);
		



		queue.addAll(ArrLis);
		
		System.out.println(queue);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.take());
		}
	}

}

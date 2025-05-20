/**
 * 
 */
package com.blockingqueue.operations;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Aqeel
 */
public class Test_remainingCapacity {

	/**
	 * @param args
	 * 
	 *  IllegalArgumentException
	 */
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
		
		System.out.println(queue);
		
		int count = 1;
		
		while(count<=5) {
			queue.add(count);
			
			System.out.println(queue.remainingCapacity());
			
			++count;
		}

	}

}

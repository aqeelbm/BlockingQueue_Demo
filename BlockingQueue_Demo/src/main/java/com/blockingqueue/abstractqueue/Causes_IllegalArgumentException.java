/**
 * 
 */
package com.blockingqueue.abstractqueue;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Aqeel
 */
public class Causes_IllegalArgumentException {

	/**
	 *  This program illustrates how addAll() method from AbstractQueue 
	 *  can cause IllegalArgumentException
	 */
	public static void main(String[] args) {
		AbstractQueue<Integer> queue = new ArrayBlockingQueue<>(3);
		
		System.out.println(queue);
		
		queue.addAll(queue);
		
		System.out.println(queue);

	}

}

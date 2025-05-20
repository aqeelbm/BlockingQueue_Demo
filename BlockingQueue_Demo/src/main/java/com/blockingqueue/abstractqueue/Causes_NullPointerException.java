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
public class Causes_NullPointerException {

	/**
	 * This program illustrates how addAll() method from AbstractQueue 
	 * can cause java.lang.NullPointerException
	 */
	public static void main(String[] args) {
		AbstractQueue<Integer> queue = new ArrayBlockingQueue<>(3);
		
		List<Integer> list = null;

		System.out.println(queue);
		System.out.println(list);
		
		queue.addAll(list);
		
		System.out.println(queue);

	}

}

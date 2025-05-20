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
public class Causes_IllegalStateException {

	/**
	 * This program illustrates how addAll() method from AbstractQueue 
	 * can cause java.lang.IllegalStateException
	 */
	public static void main(String[] args) {
		AbstractQueue<Integer> queue = new ArrayBlockingQueue<>(3);

		List<Integer> elements02 = Arrays.asList(11,12,13,14,15);

		System.out.println(queue);

		queue.addAll(elements02);

		System.out.println(queue);

	}

}

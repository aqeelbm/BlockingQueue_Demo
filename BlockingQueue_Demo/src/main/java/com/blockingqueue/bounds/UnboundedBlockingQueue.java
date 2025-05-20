/**
 * 
 */
package com.blockingqueue.bounds;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Aqeel
 */
public class UnboundedBlockingQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
		
		// adding thread
		new Thread(() -> {
			int i=0;
			try {
				while(true) {
					queue.put(++i);
					System.out.println("Added: " + i);
					
					Thread.sleep(TimeUnit.SECONDS.toMillis(1));
				}
			} catch(InterruptedException ex) {
				System.out.println(ex);
			}
		}).start();
		
		
		// polling thread
		new Thread(() -> {
			try {
				while(true) {
					Integer poll = queue.take();
					System.out.println("Pulled......: "+poll);
					
					Thread.sleep(TimeUnit.SECONDS.toMillis(10));
				}
			} catch(InterruptedException ex) {
				System.out.println(ex);
			}
		}).start();
		
		
	}

}

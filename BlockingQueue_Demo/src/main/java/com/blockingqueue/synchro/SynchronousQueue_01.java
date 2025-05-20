/**
 * 
 */
package com.blockingqueue.synchro;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author Aqeel
 */
public class SynchronousQueue_01 {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<String> myQ = new SynchronousQueue<String>();

		Thread producerT = new Thread(() -> {
			try {
				System.out.println("Hello");
				System.out.println(myQ.size());
				myQ.put("Hello");
				System.out.println("size: "+myQ.size());

				pause();

				System.out.println("World");
				myQ.put("World");
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		});

		Thread consumerT = new Thread(() -> {
			try {
				System.out.println("size: "+myQ.size());
				String msg1 =myQ.take();
				System.out.println(msg1);
				String msg2 =myQ.take();			
				System.out.println(msg2);
			} catch(InterruptedException e) {
				System.out.println(e);
			}

		});

		producerT.start();
		consumerT.start();

	}

	/**
	 * 
	 */
	private static void pause() {
		try {
			Thread.sleep(2000);
		} catch(InterruptedException ex) {
			System.out.println(ex);
		}
	}


}

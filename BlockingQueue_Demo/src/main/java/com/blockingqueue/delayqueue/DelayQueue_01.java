/**
 * 
 */
package com.blockingqueue.delayqueue;

import java.util.concurrent.DelayQueue;

/**
 * @author Aqeel
 */
public class DelayQueue_01 {
	public static void main(String[] args) throws InterruptedException
	{
		DelayQueue<DelayTask> delayQueue = new DelayQueue<>();

		// Add tasks with different delays.
		delayQueue.add(new DelayTask(5400, "1st Task"));
		delayQueue.add(new DelayTask(500, "2nd Task"));
		delayQueue.add(new DelayTask(3200, "3rd Task"));
		delayQueue.add(new DelayTask(10200, "4th Task"));

		 // Process tasks as they become available.
        long startTimeMillis = System.currentTimeMillis();
        
        while (!delayQueue.isEmpty()) {
            System.out.print("Get task...");

            DelayTask task = delayQueue.take();
            long stopTimeMillis = System.currentTimeMillis();

            System.out.println("done in " + (stopTimeMillis - startTimeMillis)
                + " ms! Message: " + task.getMessage());
        }
	}
}

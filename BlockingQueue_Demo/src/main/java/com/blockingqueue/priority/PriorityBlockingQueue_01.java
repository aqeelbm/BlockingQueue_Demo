/**
 * 
 */
package com.blockingqueue.priority;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Aqeel
 */
public class PriorityBlockingQueue_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PriorityBlockingQueue<Task> priorityQ =
				new PriorityBlockingQueue<>(10, new TaskComparator());
		
		priorityQ.add(new Task(2, "check the fuel in car"));
		priorityQ.add(new Task(1, "Go to office"));
		priorityQ.add(new Task(3, "check the laundry"));
		priorityQ.add(new Task(5, "watch the weather forecast"));
		priorityQ.add(new Task(4, "check the groceries"));
		
		try {
			while(!priorityQ.isEmpty()) {
				Task task = priorityQ.take();
				System.out.println(task);
			}
		} catch(InterruptedException e) {
			System.out.println(e);
		}
		
	}

}

/**
 * 
 */
package com.blockingqueue.priority;

/**
 * @author Aqeel
 */
public class Task {
	
	private int priority;
	private String description;
	
	public Task(int priority, String description) {
		this.priority = priority;
		this.description = description;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		return "Task {priority: "+priority+", description: "+description+"}";
	}
	
	

}

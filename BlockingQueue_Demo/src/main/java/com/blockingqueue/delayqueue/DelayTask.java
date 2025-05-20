/**
 * 
 */
package com.blockingqueue.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Aqeel
 */
public class DelayTask implements Delayed {

	private final long delayInNanos;
	private final String message;

	public DelayTask(long delayInMillis, String message) {
		this.delayInNanos = delayInMillis;
		this.message = message;
	}

	@Override
	public int compareTo(Delayed task) {
		if (this == task) {
			return 0;
		}

		if (task instanceof DelayTask) {
			DelayTask other = (DelayTask) task;
			return Long.compare(this.delayInNanos, other.delayInNanos);
		}

		return Long.compare(
				this.getDelay(TimeUnit.NANOSECONDS),
									task.getDelay(TimeUnit.NANOSECONDS));
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = delayInNanos - System.nanoTime();
		return unit.convert(diff, TimeUnit.NANOSECONDS);
	}

	public String getMessage() {
        return message;
    }
}

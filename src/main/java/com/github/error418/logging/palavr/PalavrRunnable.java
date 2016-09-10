package com.github.error418.logging.palavr;

import com.github.error418.logging.palavr.config.PalavrMessageProvider;

public class PalavrRunnable implements Runnable {
	
	private Palavr palavr;
	private long sleep;
	
	/**
	 * Creates a PalavrRunnable instance.
	 * 
	 * @param loggerClassName the class name to create the logger for
	 * @param messages the log message provider to use
	 * @param sleep the time to sleep after sending a log message
	 */
	public PalavrRunnable(String loggerClassName, PalavrMessageProvider palavrMessages, long sleep) {
		this.palavr = new Palavr(loggerClassName, palavrMessages);
		this.sleep = sleep;
	}

	public void run() {
		while(!Thread.interrupted()) {
			this.palavr.speak();
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

package com.github.error418.logging.palavr;

import com.github.error418.logging.palavr.config.PalavrMessages;

public class PalavrRunnable implements Runnable {
	
	private Palavr palavr;
	private long sleep;
	
	public PalavrRunnable(String loggerClassName, PalavrMessages palavrMessages, long sleep) {
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

package com.github.error418.logging.palavr;

import com.github.error418.logging.palavr.config.DefaultPalavrMessageProvider;
import com.github.error418.logging.palavr.config.PalavrMessageProvider;

/**
 * This class is not a JUnit test.
 * 
 * You may use this as an example for creating and using a {@link PalavrRunnable} instance.
 *
 */
public class ExampleRun {
	public static void main(String...strings) {
		PalavrMessageProvider messages = new DefaultPalavrMessageProvider();
		
		Thread t1 = new Thread(new PalavrRunnable("t1", messages, 1500));
		Thread t2 = new Thread(new PalavrRunnable("t1", messages, 4100));
		Thread t3 = new Thread(new PalavrRunnable("t1", messages, 7218));
	
		t1.start();
		t2.start();
		t3.start();
	}
}

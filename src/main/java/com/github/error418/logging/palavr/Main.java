package com.github.error418.logging.palavr;

import com.github.error418.logging.palavr.config.DefaultPalavrMessages;
import com.github.error418.logging.palavr.config.PalavrMessages;

public class Main {
	public static void main(String...strings) {
		PalavrMessages messages = new DefaultPalavrMessages();
		
		Thread t1 = new Thread(new PalavrRunnable("t1", messages, 1500));
		Thread t2 = new Thread(new PalavrRunnable("t1", messages, 4100));
		Thread t3 = new Thread(new PalavrRunnable("t1", messages, 7218));
	
		t1.start();
		t2.start();
		t3.start();
	}
}

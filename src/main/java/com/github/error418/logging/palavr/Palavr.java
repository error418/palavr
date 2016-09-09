package com.github.error418.logging.palavr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.error418.logging.palavr.config.DefaultPalavrMessages;
import com.github.error418.logging.palavr.config.PalavrMessages;

public class Palavr {
	private final Logger logger;
	private final PalavrMessages messages;
	
	/**
	 * Creates a Palavr instance with the {@link DefaultPalavrMessages} Message Provider.
	 * 
	 * @param loggerClassName the class name to create the logger for
	 */
	public Palavr(String loggerClassName) {
		logger = LoggerFactory.getLogger(loggerClassName);
		this.messages = new DefaultPalavrMessages();
	}
	
	/**
	 * Creates a Palavr instance.
	 * 
 	 * @param loggerClassName the class name to create the logger for
	 * @param messages the log message provider to use
	 */
	public Palavr(String loggerClassName, PalavrMessages messages) {
		logger = LoggerFactory.getLogger(loggerClassName);
		this.messages = messages;
	}
	
	/**
	 * Sends a log message from the Message Provider with a random log level.
	 */
	public void speak() {
		double random = Math.random();
		
		if(random < 0.3) {
			logger.trace(messages.getMessage());
		} else if (random < 0.4) {
			logger.debug(messages.getMessage());
		} else if (random < 0.85) {
			logger.info(messages.getMessage());
		} else if (random < 0.95) {
			logger.warn(messages.getMessage());
		} else {
			logger.error(messages.getMessage());
		}
	}
}

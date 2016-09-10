package com.github.error418.logging.palavr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.error418.logging.palavr.config.DefaultPalavrMessageProvider;
import com.github.error418.logging.palavr.config.PalavrMessageProvider;

public class Palavr {
	private final Logger logger;
	private final PalavrMessageProvider messages;
	
	/**
	 * Creates a Palavr instance with the {@link DefaultPalavrMessageProvider} Message Provider.
	 * 
	 * @param loggerClassName the class name to create the logger for
	 */
	public Palavr(String loggerClassName) {
		logger = LoggerFactory.getLogger(loggerClassName);
		this.messages = new DefaultPalavrMessageProvider();
	}
	
	/**
	 * Creates a Palavr instance.
	 * 
 	 * @param loggerClassName the class name to create the logger for
	 * @param messages the log message provider to use
	 */
	public Palavr(String loggerClassName, PalavrMessageProvider messages) {
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

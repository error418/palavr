package com.github.error418.logging.palavr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.error418.logging.palavr.config.DefaultPalavrMessages;
import com.github.error418.logging.palavr.config.PalavrMessages;

public class Palavr {
	private final Logger logger;
	private final PalavrMessages messages;
	
	public Palavr(String loggerClassName) {
		logger = LoggerFactory.getLogger(loggerClassName);
		this.messages = new DefaultPalavrMessages();
	}
	
	public Palavr(String loggerClassName, PalavrMessages messages) {
		logger = LoggerFactory.getLogger(loggerClassName);
		this.messages = messages;
	}
	
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

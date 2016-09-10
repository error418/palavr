package com.github.error418.logging.palavr.config;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * Builds random messages from two files.
 * 
 */
public class DefaultPalavrMessageProvider implements PalavrMessageProvider {

	private final List<String> nouns;
	private final List<String> messages;
	
	/**
	 * Default constructor.
	 * 
	 * Loads the messages from files located in the classpath.
	 */
	public DefaultPalavrMessageProvider() {
		
		List<String> nouns = new ArrayList<String>();
		List<String> messages = new ArrayList<String>();
		
		try {
			nouns.addAll(FileUtils.readLines(new File(ClassLoader.class.getResource("/nouns.txt").toURI()), StandardCharsets.UTF_8));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			messages.addAll(FileUtils.readLines(new File(ClassLoader.class.getResource("/message.txt").toURI()), StandardCharsets.UTF_8));
		} catch (IOException e) {
			messages.add("Something went wrong while loading the messages file.");
			e.printStackTrace();
		} catch (URISyntaxException e) {
			nouns.add("[no nouns could be loaded");
			e.printStackTrace();
		}
		
		this.nouns = nouns;
		this.messages = messages;
	}
	
	private String getRandomEntry(List<String> list) {
		Long index = Math.round(Math.random() * (list.size() - 1));
		return list.get(index.intValue());
	}

	public String getMessage() {
		return String.format(getRandomEntry(messages), getRandomEntry(nouns), getRandomEntry(nouns));
	}
	
}

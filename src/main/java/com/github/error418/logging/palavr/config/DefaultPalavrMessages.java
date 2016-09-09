package com.github.error418.logging.palavr.config;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class DefaultPalavrMessages implements PalavrMessages {

	private final List<String> nouns;
	private final List<String> messages;
	
	public DefaultPalavrMessages() {
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
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

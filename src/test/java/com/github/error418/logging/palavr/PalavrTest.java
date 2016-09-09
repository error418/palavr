package com.github.error418.logging.palavr;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.github.error418.logging.palavr.config.DefaultPalavrMessages;
import com.github.error418.logging.palavr.config.PalavrMessages;

public class PalavrTest {
	
	private Palavr utt;
	private PalavrMessages messages;
	
	@Before
	public void init() {
		messages = Mockito.mock(DefaultPalavrMessages.class);
		Mockito.when(messages.getMessage()).thenReturn("this is a test");
		
		utt = new Palavr("test", messages);
	}
	
	@Test
	public void testLog() throws Exception {
		utt.speak();
		Mockito.verify(messages, Mockito.times(1)).getMessage();
	}
}

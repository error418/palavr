package com.github.error418.logging.palavr;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.github.error418.logging.palavr.config.DefaultPalavrMessageProvider;
import com.github.error418.logging.palavr.config.PalavrMessageProvider;

public class PalavrTest {
	
	private Palavr utt;
	private PalavrMessageProvider messages;
	
	@Before
	public void init() {
		messages = Mockito.mock(DefaultPalavrMessageProvider.class);
		Mockito.when(messages.getMessage()).thenReturn("this is a test");
		
		utt = new Palavr("test", messages);
	}
	
	/**
	 * Tests if {@link PalavrMessageProvider#getMessage()} is called when invoking {@link Palavr#speak()}
	 * @throws Exception
	 */
	@Test
	public void testLog() throws Exception {
		utt.speak();
		Mockito.verify(messages, Mockito.times(1)).getMessage();
	}
}

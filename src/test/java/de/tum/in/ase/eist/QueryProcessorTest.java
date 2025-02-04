package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}

	@Test
	void isNotCaseSensitive2() {
		String actual = queryProcessor.process("name");
		if (!actual.contains("Suren")) {
			fail("Your QueryProcessor does not know about name.");
		}
	}
	@Test
	void isNotCaseSensitive3() {
		String actual = queryProcessor.process("plus");
		if (!actual.contains("406")) {
			fail("Wrong");
		}
	}
}

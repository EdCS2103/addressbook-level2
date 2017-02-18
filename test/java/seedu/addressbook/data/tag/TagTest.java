package seedu.addressbook.data.tag;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class TagTest {

	@Test
	public void testEqualsObject() throws IllegalValueException {
		Tag test = new Tag("Edward");
		Tag test2 = new Tag("Edward");
		assertEquals(test, test2);
	}

}

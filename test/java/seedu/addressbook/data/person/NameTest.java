package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
/**
 * test for method isSimilar in Name Class
 * @throws IllegalValueException 
 */
	@Test
	public void testIsSimilar() throws IllegalValueException{
		Name handsome = new Name("henry");
		Name pretty = new Name("chia");
		assertFalse(handsome.isSimilar(pretty));
	}

}

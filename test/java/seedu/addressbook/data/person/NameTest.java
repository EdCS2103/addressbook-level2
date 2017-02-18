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
		Name handsome2 = new Name("henry");
		Name diffCase = new Name("HenRy");
		Name superset = new Name("Henry Cheese");
		Name nullset = null;
		
		assertFalse(handsome.isSimilar(pretty));
		assertTrue(handsome.isSimilar(handsome));
		assertTrue(handsome.isSimilar(handsome2));
		
		assertTrue(handsome.isSimilar(diffCase));
		assertTrue(handsome.isSimilar(superset));
		assertFalse(handsome.isSimilar(nullset));
	}

}

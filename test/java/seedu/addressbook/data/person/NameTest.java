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
		
		testSameFullName();
		testDiffCase();
		testSuperOrSubSet();
		testNullSet();
	}

private void testNullSet() throws IllegalValueException {
	Name handsome = new Name("henry");
	Name nullset = null;
	assertFalse(handsome.isSimilar(nullset));
}

private void testSuperOrSubSet() throws IllegalValueException {
	Name handsome = new Name("henry");
	Name superset1 = new Name("Henry Cheese");
	Name superset2 = new Name("henry Cheesecake");
	assertTrue(superset1.isSimilar(handsome));
	assertTrue(handsome.isSimilar(superset1));
	assertTrue(handsome.isSimilar(superset2));
	assertTrue(superset2.isSimilar(handsome));
}

private void testDiffCase() throws IllegalValueException {
	Name handsome = new Name("henry");
	Name diffCase = new Name("HenRy");
	assertTrue(handsome.isSimilar(diffCase));
	assertTrue(diffCase.isSimilar(handsome));
}

private void testSameFullName() throws IllegalValueException {
	Name handsome = new Name("henry");
	Name pretty = new Name("chia");
	Name handsome2 = new Name("henry");
	
	assertFalse(handsome.isSimilar(pretty));
	assertFalse(pretty.isSimilar(handsome));
	assertTrue(handsome.isSimilar(handsome));
	assertTrue(handsome.isSimilar(handsome2));
	assertTrue(handsome2.isSimilar(handsome));
}

}

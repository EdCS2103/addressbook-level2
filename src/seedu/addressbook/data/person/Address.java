package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import java.util.regex.*;

/**
 * Represents a Person's address in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

	public static final String EXAMPLE = "123, some street, #12-34, 123456";
	public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be written in the order: block, street, unit, postal code";
	public static final String ADDRESS_VALIDATION_REGEX = ".+";

	private String value;
	private boolean isPrivate;

	public Block block;
	public Street street;
	public Unit unit;
	public PostalCode postalCode;

	/**
	 * Validates given address.
	 *
	 * @throws IllegalValueException
	 *             if given address string is invalid.
	 */
	public Address(String address, boolean isPrivate) throws IllegalValueException {
		String trimmedAddress = address.trim();
		this.value = trimmedAddress;
		this.isPrivate = isPrivate;
		String[] disectedAddress = disectAddress(trimmedAddress);
		setAddress(disectedAddress);
	}

	public void setAddress(String[] disectedAddress) throws IllegalValueException {
		this.block = new Block(disectedAddress[0]);
		this.street = new Street(disectedAddress[1]);
		this.unit = new Unit(disectedAddress[2]);
		this.postalCode = new PostalCode(disectedAddress[3]);
	}

	private String[] disectAddress(String trimmedAddress) {
		return trimmedAddress.split(", ");
	}

	/**
	 * Returns true if a given string is a valid person email.
	 */
	public static boolean isValidAddress(String test) {
		return test.matches(ADDRESS_VALIDATION_REGEX);
	}

	@Override
	public String toString() {
		return this.value;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Address // instance of handles nulls
						&& this.value.equals(((Address) other).value)); // state
																		// check
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public boolean isPrivate() {
		return isPrivate;
	}
}

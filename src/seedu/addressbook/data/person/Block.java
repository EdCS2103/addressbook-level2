package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Block {
	private static final String MESSAGE_ADDRESS_INVALID = "Blocks must begin with 3digits and it may end with an alphabet";
	private static final String VALID_BLOCK_INDEX = "[0-9]{3}[a-zA-Z]{0,1}";
	private String _block;

	public Block(String block) throws IllegalValueException {
		if (!isValidBlock(block)) {
			throw new IllegalValueException(MESSAGE_ADDRESS_INVALID);
		} else {
			this._block = block;
		}
	}

	private boolean isValidBlock(String block) {
		return block.matches(VALID_BLOCK_INDEX);
	}

	public String get_block() {
		return _block;
	}

	public void set_block(String _block) {
		this._block = _block;
	}
}

package seedu.addressbook.data.person;

public class AddressBlock {

	private String _block;

	public AddressBlock(String trim) {
		set_block(trim);
	}

	public String get_block() {
		return _block;
	}

	public void set_block(String _block) {
		this._block = _block;
	}
	
	@Override
	public String toString(){
		return _block;
	}

}

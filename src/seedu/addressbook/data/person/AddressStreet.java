package seedu.addressbook.data.person;

public class AddressStreet {

	private String _street;
	
	public AddressStreet(String trim) {
		set_street(trim);
	}

	public String get_street() {
		return _street;
	}

	public void set_street(String _street) {
		this._street = _street;
	}

	@Override
	public String toString(){
		return _street;
	}
}

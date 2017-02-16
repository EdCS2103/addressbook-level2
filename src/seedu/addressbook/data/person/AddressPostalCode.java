package seedu.addressbook.data.person;

public class AddressPostalCode {

	private String _postalCode;
	public AddressPostalCode(String trim) {
		set_postalCode(trim);
	}
	public String get_postalCode() {
		return _postalCode;
	}
	public void set_postalCode(String _postalCode) {
		this._postalCode = _postalCode;
	}

	@Override
	public String toString(){
		return _postalCode;
	}
}

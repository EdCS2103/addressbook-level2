package seedu.addressbook.data.person;

public class AddressUnit {

	private String _unit;
	
	public AddressUnit(String trim) {
		this.set_unit(trim);
	}

	public String get_unit() {
		return _unit;
	}

	public void set_unit(String _unit) {
		this._unit = _unit;
	}

	@Override
	public String toString(){
		return _unit;
	}
}

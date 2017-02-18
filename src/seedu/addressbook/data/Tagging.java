package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.UniqueTagList;

public class Tagging {
	
	private boolean isAdd;
	private Person person;
	private UniqueTagList tag;

	
	public Tagging(boolean isAdd, Person person, UniqueTagList uniqueTagList){
		this.person = person;
		this.tag = uniqueTagList;
		this.isAdd = isAdd;
	}	

	public String getTaggingRecords(){
		StringBuilder taggingBuilder = new StringBuilder();
		if(isAdd){
			taggingBuilder.append("+ ");			
		}
		else{
			taggingBuilder.append("- ");
		}
		taggingBuilder.append(person.getName() + " " + tag.toString());
		return taggingBuilder.toString();
	}
	
	@Override
	public String toString(){
		return getTaggingRecords();
	}
}

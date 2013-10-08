package edu.unisa.dspace.entities.request.items;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "field")

public class Field {
	private String name;
	private String value;
	
	
	
	public Field() {

	}
	public Field(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	
	
}

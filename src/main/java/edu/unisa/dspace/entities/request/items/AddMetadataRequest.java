package edu.unisa.dspace.entities.request.items;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="request")

public class AddMetadataRequest {
	private int id;
	private String value;

		
	
	public AddMetadataRequest() {

	}
	
	public AddMetadataRequest(int id, String value) {
		super();
		this.id = id;
		this.value = value;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	
	
	
	
}

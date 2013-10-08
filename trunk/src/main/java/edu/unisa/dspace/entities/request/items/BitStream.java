package edu.unisa.dspace.entities.request.items;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bitstream")
public class BitStream {
	private String name;
	private String mimeType;
	private String description;
	private boolean primary;
	
	
	
	
	public BitStream() {

	}

	public BitStream(String name, String mimeType, String description,
			boolean primary) {
		super();
		this.name = name;
		this.mimeType = mimeType;
		this.description = description;
		this.primary = primary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	
	
	
}

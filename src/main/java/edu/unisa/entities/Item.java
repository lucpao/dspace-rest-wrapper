package edu.unisa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlRootElement(name = "item")
// If you want you can define the order in which the fields are written
// Optional
@XmlType(propOrder = { "handle", "id","metadata"})
public class Item {

  private String handle;
  private String id;
 private List<Metadata> metadataList;
  
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public List<Metadata> getMetadata() {
		return metadataList;
	}
	
	@XmlElementWrapper(name = "metadata")
	@XmlElement(name = "metadata", type = Metadata.class)
	public void setMetadata(List<Metadata> metadata) {
		this.metadataList = (List<Metadata>) metadata;
	}
	
	@Override
	public String toString() {
		return "Item [handle=" + handle + ", id=" + id + "]";
	}

  

  
  

} 
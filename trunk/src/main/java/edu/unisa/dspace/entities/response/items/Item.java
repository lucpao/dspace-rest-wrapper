package edu.unisa.dspace.entities.response.items;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlRootElement(name = "item")
// If you want you can define the order in which the fields are written
// Optional
//@XmlType(propOrder = { "handle", "id","isArchived","isWithdrawn","lastModified","metadata","name"})
public class Item {

  private String handle;
  private String id;
  private boolean isArchived;
  private boolean isWithdrawn;
  private String lastModified;
  private String name; 
  
  
  
 public boolean isArchived() {
	return isArchived;
}
public void setArchived(boolean isArchived) {
	this.isArchived = isArchived;
}
public boolean isWithdrawn() {
	return isWithdrawn;
}
public void setWithdrawn(boolean isWithdrawn) {
	this.isWithdrawn = isWithdrawn;
}
public String getLastModified() {
	return lastModified;
}
public void setLastModified(String lastModified) {
	this.lastModified = lastModified;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Metadata> getMetadataList() {
	return metadataList;
}
public void setMetadataList(List<Metadata> metadataList) {
	this.metadataList = metadataList;
}

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
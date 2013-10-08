package edu.unisa.dspace.entities.response.items;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

// If you want you can define the order in which the fields are written
// Optional
@XmlType(propOrder = { "element", "id","qualifier","schema","value"})
public class Metadata {

  private String element;
  private String id;
  private String qualifier;
  private String schema;
  private String value;
  
  public String getElement() {
	return element;
}
public void setElement(String element) {
	this.element = element;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getQualifier() {
	return qualifier;
}
public void setQualifier(String qualifier) {
	this.qualifier = qualifier;
}
public String getSchema() {
	return schema;
}
public void setSchema(String schema) {
	this.schema = schema;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
@Override
public String toString() {
	return "Metadata [element=" + element + ", id=" + id + ", qualifier="
			+ qualifier + ", schema=" + schema + ", value=" + value + "]";
}

  
  


  

  
  

} 

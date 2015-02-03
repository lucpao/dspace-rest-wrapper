package it.unisa.dspace.entities.response.items;

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
  
  
  
  
  public Metadata() {
    super();
}
public Metadata(String schema,String qualifier, String element,  String value) {
    super();
    this.element = element;
    this.qualifier = qualifier;
    this.schema = schema;
    this.value = value;
}
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

  public String fullName() {
      String output="";
      if (schema !=null) output+=schema+".";
      if (element!=null) output+=element;
      if (qualifier!=null && !qualifier.equals("")) output+="."+qualifier;
      return output;
  }
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((element == null) ? 0 : element.hashCode());
    result = prime * result + ((qualifier == null) ? 0 : qualifier.hashCode());
    result = prime * result + ((schema == null) ? 0 : schema.hashCode());
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
}
@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Metadata other = (Metadata) obj;
    if (element == null) {
        if (other.element != null)
            return false;
    } else if (!element.equals(other.element))
        return false;
    if (qualifier == null) {
        if (other.qualifier != null)
            return false;
    } else if (!qualifier.equals(other.qualifier))
        return false;
    if (schema == null) {
        if (other.schema != null)
            return false;
    } else if (!schema.equals(other.schema))
        return false;
    if (value == null) {
        if (other.value != null)
            return false;
    } else if (!value.equals(other.value))
        return false;
    return true;
}


  
  


  

  
  

} 

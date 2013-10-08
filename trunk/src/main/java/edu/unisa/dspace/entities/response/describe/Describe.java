package edu.unisa.dspace.entities.response.describe;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "describe")
// If you want you can define the order in which the fields are written
// Optional
@XmlType(propOrder = { "describeURL", "version" })
public class Describe {

  public Describe() {
		super();
	}
private String describeURL;
  private String version;
  
	public String getDescribeURL() {
		return describeURL;
	}
	public void setDescribeURL(String describeURL) {
		this.describeURL = describeURL;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
  

  


} 

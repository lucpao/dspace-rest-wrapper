package it.unisa.dspace.entities.request.items;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlSeeAlso({Bundle.class})
@XmlType(propOrder = { "name", "bitstreams"})
public class Bundle {
	private String name;
	private List<BitStream> bitstreams;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElementWrapper(name = "bitstreams")
	@XmlElement(name = "bitstream", type=BitStream.class)
	public List<BitStream> getBitstreams() {
		return bitstreams;
	}
	public void setBitstreams(List<BitStream> bitstreams) {
		this.bitstreams = bitstreams;
	}

	
	
	




} 

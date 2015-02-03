package it.unisa.dspace.entities.request.items;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlRootElement
@XmlSeeAlso({BitStream.class})
public class BitStreams extends ArrayList<BitStream>{


	public BitStreams() {

	}

	@XmlElementWrapper(name = "bitstreams")
	@XmlElement(name = "bitstream", type=BitStream.class)
	public List<BitStream> getBitStreams() {
		return this;
	}


} 

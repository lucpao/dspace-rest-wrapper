package it.unisa.dspace.entities.response.bitstreams;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bundle")

public class ResponseBundle {


	private String id;

	private String name; 
	private String primaryBitstreamId;
	private List<ResponseBitstream> bitstreamList;




	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}





	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public List<ResponseBitstream> getBitstreams() {
		return bitstreamList;
	}

	@XmlElementWrapper(name = "bitstreams")
	@XmlElement(name = "bitstream", type = ResponseBitstream.class)
	public void setBitstreams(List<ResponseBitstream> bitstreams) {
		this.bitstreamList = (List<ResponseBitstream>) bitstreams;
	}
	@Override
	public String toString() {
		return "Bundle [id=" + id + ", name=" + name + ", primaryBitstreamId="
				+ primaryBitstreamId + "]";
	}
	
	

}


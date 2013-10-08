package edu.unisa.dspace.entities.response.items;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlRootElement
@XmlSeeAlso({Metadata.class})
public class MetadataList extends ArrayList<Metadata>{


	public MetadataList() {

	}

	@XmlElementWrapper(name = "metadata")
	@XmlElement(name = "metadata", type=Metadata.class)
	public List<Metadata> getMetadata() {
		return this;
	}


} 

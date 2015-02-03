package it.unisa.dspace.entities.request.items;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlRootElement
@XmlSeeAlso({Bundle.class})
public class Bundles extends ArrayList<Bundle>{


	public Bundles() {

	}

	@XmlElementWrapper(name = "bundles")
	@XmlElement(name = "bundle", type=Bundle.class)
	public List<Bundle> getBundles() {
		return this;
	}


} 

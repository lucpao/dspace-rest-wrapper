package it.unisa.dspace.entities.response.bitstreams;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name="bundles")
@XmlSeeAlso({ResponseBundle.class})
public class ResponseBundles extends ArrayList<ResponseBundle>{

	  public ResponseBundles() {
		    
		  }

		  @XmlElement(name = "bundle")
		  public List<ResponseBundle> getBundles() {
		    return this;
		  }


} 

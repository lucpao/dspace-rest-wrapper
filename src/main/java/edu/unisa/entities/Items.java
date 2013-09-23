package edu.unisa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({Item.class})
public class Items extends ArrayList<Item>{

	  public Items() {
		    
		  }

		  @XmlElement(name = "item")
		  public List<Item> getItems() {
		    return this;
		  }


} 

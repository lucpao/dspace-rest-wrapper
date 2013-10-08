package edu.unisa.dspace.entities.response.users;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({User.class})
public class Users extends ArrayList<User>{

	  public Users() {
		    
		  }

		  @XmlElement(name = "user")
		  public List<User> getUsers() {
		    return this;
		  }


} 

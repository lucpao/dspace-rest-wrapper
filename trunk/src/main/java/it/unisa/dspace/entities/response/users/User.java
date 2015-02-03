package it.unisa.dspace.entities.response.users;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "user")
// If you want you can define the order in which the fields are written
// Optional
@XmlType(propOrder = { "canLogIn", "email", "firstName", "fullName" })
public class User {

  private String canLogIn;
  private String email;
  private String firstName;
  private String fullName;
public String getCanLogIn() {
	return canLogIn;
}
public void setCanLogIn(String canLogIn) {
	this.canLogIn = canLogIn;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
@Override
public String toString() {
	return "User [canLogIn=" + canLogIn + ", email=" + email + ", firstName="
			+ firstName + ", fullName=" + fullName + "]";
}


  
  

} 

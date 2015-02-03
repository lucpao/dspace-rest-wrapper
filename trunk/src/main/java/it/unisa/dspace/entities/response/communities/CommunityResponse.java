package it.unisa.dspace.entities.response.communities;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "response")

@XmlType(propOrder = { "communityId"})
public class CommunityResponse {
	
	  public CommunityResponse() {
			super();
		}
	  private String communityId;
	  
		public String getCommunityId() {
			return communityId;
		}
		public void setCommunityId(String communityId) {
			this.communityId = communityId;
		}
		  


  


} 

package edu.unisa.dspace.entities.request.communities;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="request")
@XmlType(propOrder = { "communityId", "name","shortDescription","introductoryText","copyrightText"})
public class CommunityRequest {
	private int communityId;
	private String name;
	private String shortDescription;
	private String introductoryText;
	private String copyrightText;
	
	
	
	public CommunityRequest() {

	}
	public CommunityRequest(int communityId, String name, String shortDescription,
			String introductoryText, String copyrightText) {
		super();
		this.communityId = communityId;
		this.name = name;
		this.shortDescription = shortDescription;
		this.introductoryText = introductoryText;
		this.copyrightText = copyrightText;
	}
	public int getCommunityId() {
		return communityId;
	}
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getIntroductoryText() {
		return introductoryText;
	}
	public void setIntroductoryText(String introductoryText) {
		this.introductoryText = introductoryText;
	}
	public String getCopyrightText() {
		return copyrightText;
	}
	public void setCopyrightText(String copyrightText) {
		this.copyrightText = copyrightText;
	}
	

	
	
	
}

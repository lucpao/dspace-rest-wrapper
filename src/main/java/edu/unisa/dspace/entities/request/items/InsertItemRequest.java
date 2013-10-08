package edu.unisa.dspace.entities.request.items;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "collectionId", "metadata","bundles"})
public class InsertItemRequest {
	private int collectionId;
	private List<Field> metadata;
	private List<Bundle> bundles;
	
	
	public int getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}
	@XmlElementWrapper(name = "metadata")
	@XmlElement(name = "field", type=Field.class)
	public List<Field> getMetadata() {
		return metadata;
	}
	public void setMetadata(List<Field> metadata) {
		this.metadata = metadata;
	}
	
	@XmlElementWrapper(name = "bundles")
	@XmlElement(name = "bundle", type=Bundle.class)
	public List<Bundle> getBundles() {
		return bundles;
	}
	public void setBundles(List<Bundle> bundles) {
		this.bundles = bundles;
	}
	
	
	
}

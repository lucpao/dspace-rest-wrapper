package it.unisa.dspace.entities.request.items;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="request")
public class UpdateMetadataRequest {

	private List<Field> metadata = new ArrayList<Field>();

	@XmlElementWrapper(name = "metadata")
	@XmlElement(name = "field", type=Field.class)
	public List<Field> getMetadata() {
		return metadata;
	}


	public void setMetadata(List<Field> metadata) {
		this.metadata = metadata;
	}
	
	public void addMetadataField(Field field) {
		metadata.add(field);
	}
	
	
}

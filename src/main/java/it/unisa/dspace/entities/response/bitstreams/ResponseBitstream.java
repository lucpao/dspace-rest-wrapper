package it.unisa.dspace.entities.response.bitstreams;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bitstream")
public class ResponseBitstream {
	private String checkSum;
	private String checkSumAlgorithm;
	private String description;
	private String formatDescription;
	private int id;
	private String mymeType;
	private String name;
	private int sequenceId;
	private String size;
	private String source;
	private String storeNumber;
	private String userFormatDescription;
	public String getCheckSum() {
		return checkSum;
	}
	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}
	public String getCheckSumAlgorithm() {
		return checkSumAlgorithm;
	}
	public void setCheckSumAlgorithm(String checkSumAlgorithm) {
		this.checkSumAlgorithm = checkSumAlgorithm;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFormatDescription() {
		return formatDescription;
	}
	public void setFormatDescription(String formatDescription) {
		this.formatDescription = formatDescription;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMymeType() {
		return mymeType;
	}
	public void setMymeType(String mymeType) {
		this.mymeType = mymeType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSequenceId() {
		return sequenceId;
	}
	public void setSequenceId(int sequenceId) {
		this.sequenceId = sequenceId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}
	public String getUserFormatDescription() {
		return userFormatDescription;
	}
	public void setUserFormatDescription(String userFormatDescription) {
		this.userFormatDescription = userFormatDescription;
	}
	@Override
	public String toString() {
		return "Bitstream [checkSum=" + checkSum + ", checkSumAlgorithm="
				+ checkSumAlgorithm + ", description=" + description
				+ ", formatDescription=" + formatDescription + ", id=" + id
				+ ", mymeType=" + mymeType + ", name=" + name + ", sequenceId="
				+ sequenceId + ", size=" + size + ", source=" + source
				+ ", storeNumber=" + storeNumber + ", userFormatDescription="
				+ userFormatDescription + "]";
	}
	
	
	


	
	
}

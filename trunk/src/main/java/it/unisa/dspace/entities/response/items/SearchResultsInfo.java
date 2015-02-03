package it.unisa.dspace.entities.response.items;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="searchresultsinfo")
public class SearchResultsInfo {
    private int id;
    private String name;
    private int resultCount;
    
    
    
    public SearchResultsInfo() {
     
    }
    @XmlElement(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name = "resultsCount")
    public int getResultCount() {
        return resultCount;
    }
    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    private ArrayList<String> resultHandles = new ArrayList<String>();
    
    @XmlElementWrapper(name = "resultHandles")
    @XmlElement(name = "string", type=String.class)
    public List<String> getResultHandles() {
        return resultHandles;
    }

    private ArrayList<Integer> resultIDs = new ArrayList<Integer>();
    @XmlElementWrapper(name = "resultIDs")
    @XmlElement(name = "integer", type=Integer.class)
    public List<Integer> getResultIDs() {
        return resultIDs;
    }
    
    private ArrayList<Integer> resultTypes = new ArrayList<Integer>();
    @XmlElementWrapper(name = "resultTypes")
    @XmlElement(name = "integer", type=Integer.class)
    public List<Integer> getResultTypes() {
        return resultTypes;
    }
    
}

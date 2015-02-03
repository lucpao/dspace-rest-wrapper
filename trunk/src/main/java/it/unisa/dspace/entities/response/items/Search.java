package it.unisa.dspace.entities.response.items;

import it.unisa.dspace.entities.request.items.Bundle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "search")
@XmlSeeAlso({SearchResultsInfo.class})
public class Search {
    
    
    
    private SearchResultsInfo searchResultsInfo ;

    
    
    public Search() {

    }


    public void setSearchResultsInfo(SearchResultsInfo searchResultsInfo) {
        this.searchResultsInfo = searchResultsInfo;
    }


    @XmlElement(name = "searchresultsinfo")
    public SearchResultsInfo getSearchResultsInfo() {
        return searchResultsInfo;
    }
    

}

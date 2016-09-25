
package com.hardikgoswami.eventsapp.data.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Eventlist {

    private List<Website> websites = new ArrayList<Website>();
    private String quote_max;
    private String quote_available;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The websites
     */
    public List<Website> getWebsites() {
        return websites;
    }

    /**
     * 
     * @param websites
     *     The websites
     */
    public void setWebsites(List<Website> websites) {
        this.websites = websites;
    }

    /**
     * 
     * @return
     *     The quote_max
     */
    public String getQuote_max() {
        return quote_max;
    }

    /**
     * 
     * @param quote_max
     *     The quote_max
     */
    public void setQuote_max(String quote_max) {
        this.quote_max = quote_max;
    }

    /**
     * 
     * @return
     *     The quote_available
     */
    public String getQuote_available() {
        return quote_available;
    }

    /**
     * 
     * @param quote_available
     *     The quote_available
     */
    public void setQuote_available(String quote_available) {
        this.quote_available = quote_available;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

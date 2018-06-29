package com.scent.core.data;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
import static com.scent.core.util.Constants.JSON_RESPONSE_FILTER;

@JsonFilter(JSON_RESPONSE_FILTER)
public class ResponseData {

    @JsonProperty("responses")
    private Map<String, Object> dataMap;
    /**
     * Response data constructor
     */
    public ResponseData() {
        dataMap = new HashMap<>();
    }

    /**
     * This method is used to get response data.
     *
     * @param name
     *            String parameter to get data
     * @return Object Returns data object
     */
    public Object getData(String name) {
        return dataMap.get(name);
    }

    /**
     * This method is used to set response data.
     *
     * @param name
     *            Key to be set in data map.
     * @param value
     *            Value to be set in data map.
     */
    public void setData(String name, Object value) {
        dataMap.put(name, value);
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "dataMap=" + dataMap +
                '}';
    }
}

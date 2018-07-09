package com.scent.core.Steps;

import com.scent.core.data.EventData;
import com.scent.core.data.ResponseData;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

public interface IStep<T> {
    Mono<T> executeStep(EventData eventData);
    default Map<String, String> getRequestParamsCopy(Map<String, String> dataMap) {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.putAll(dataMap);
        return paramsMap;
    }
    default ResponseData updateResponse(String eventName, EventData eventData,
                                        Object data) {
        ResponseData responseData = eventData.getResponseData();
        responseData.setData(eventName, data);
        eventData.setResponseData(responseData);
        return responseData;
    }
}

package com.scent.core.handler;

import com.scent.core.data.EventData;
import com.scent.core.data.ResponseData;

public  interface BaseHandler {
    default ResponseData updateResponse(String eventName, EventData eventData,
                                        Object data) {
        ResponseData responseData = eventData.getResponseData();
        responseData.setData(eventName, data);
        eventData.setResponseData(responseData);
        return responseData;
    }
}

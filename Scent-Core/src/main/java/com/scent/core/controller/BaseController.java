package com.scent.core.controller;


import com.scent.core.data.EventData;
import com.scent.core.data.RequestData;
import com.scent.core.data.ResponseData;

import java.util.Map;

public class BaseController {

    protected EventData gerEventData(Map<String, String> queryParams){
        EventData eventData = new EventData();
        RequestData requestData = getRequestData(queryParams);
        eventData.setRequestData(requestData);
        eventData.setResponseData(getResponseData());
        return eventData;

    }
    protected RequestData getRequestData(Map<String, String> queryParams) {
        RequestData requestData = new RequestData();
        requestData.setDataMap(queryParams);
        return requestData;
    }

    protected ResponseData getResponseData(){
        ResponseData responseData = new ResponseData();
        return responseData;
    }
}

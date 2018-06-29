package com.scent.accountservice.controller.handler;

import com.scent.core.data.EventData;
import com.scent.core.util.CommonUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.scent.core.util.Constants.ACCOUNT_CREATION_FAILED_CODE;
import static com.scent.core.util.Constants.ACOUNT_ALREADY_EXISTS_CODE;
import static com.scent.core.util.Constants.STAUS_CODE;

@Component
public class CreateAccountHandler {
    @Autowired
    GetAccountStep getAccountStep;
    @Autowired
    CreateAccountStep signUp;
    public Mono<JSONObject> getresult(EventData eventData){
        return getAccountStep.executeStep(eventData).flatMap(jsonObject -> {
            if(CommonUtil.isSuccessResponse(jsonObject)) {
                jsonObject.put(STAUS_CODE, ACCOUNT_CREATION_FAILED_CODE);
                return Mono.just(jsonObject);
               // return  signUp.executeStep(eventData);
            }else{
                jsonObject.put(STAUS_CODE, ACOUNT_ALREADY_EXISTS_CODE);
                return Mono.just(jsonObject);
            }
        });
    }
}

package com.scent.accountservice.handler;

import com.scent.accountservice.steps.profile.CreateAccountStep;
import com.scent.accountservice.steps.profile.GetAccountStep;
import com.scent.core.data.EventData;
import com.scent.core.data.ResponseData;
import com.scent.core.handler.BaseHandler;
import com.scent.core.util.CommonUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.scent.core.util.Constants.ACOUNT_ALREADY_EXISTS_CODE;
import static com.scent.core.util.Constants.STAUS_CODE;

@Component
public class CreateAccountHandler implements BaseHandler {
    @Autowired
    GetAccountStep getAccountStep;
    @Autowired
    CreateAccountStep signUp;
    public Mono<ResponseData> getresult(EventData eventData){
        return getAccountStep.executeStep(eventData).flatMap(responseData -> {
            JSONObject jsonObject = (JSONObject) responseData.getData(GetAccountStep.class.getSimpleName());
            if(CommonUtil.isSuccessResponse(jsonObject)) {
                System.out.println(jsonObject);
                return signUp.executeStep(eventData);
            }else{
                jsonObject.put(STAUS_CODE, ACOUNT_ALREADY_EXISTS_CODE);
                return Mono.just(updateResponse(CreateAccountHandler.class.getSimpleName(), eventData, jsonObject));
            }
        });
    }
}

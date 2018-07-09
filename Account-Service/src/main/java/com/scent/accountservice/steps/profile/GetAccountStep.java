package com.scent.accountservice.steps.profile;


import com.scent.accountservice.repository.AccountRepository;
import com.scent.core.Steps.IStep;
import com.scent.core.data.EventData;
import com.scent.core.data.RequestData;
import com.scent.core.data.ResponseData;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;

import static com.scent.accountservice.util.AccountConstans.EMAIL_ID;
import static com.scent.accountservice.util.AccountConstans.LOGIN_BY_EMAIL;
import static com.scent.accountservice.util.AccountConstans.LOGIN_BY_MOBILE;
import static com.scent.accountservice.util.AccountConstans.LOGIN_TYPE;
import static com.scent.accountservice.util.AccountConstans.MOBILE_NUIMBER;
import static com.scent.core.util.Constants.*;

@Component
public class GetAccountStep implements IStep<ResponseData> {
    private AccountRepository accountRepository;
    public GetAccountStep(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public Mono<ResponseData>  executeStep(EventData eventData) {
        final RequestData requestData = eventData.getRequestData();
        Map<String, String> paramMap =  getRequestParamsCopy(requestData.getDataMap());
        String signUpType = paramMap.get(LOGIN_TYPE);
        Mono<Long> accountCount = Mono.empty();
        if(signUpType.equals(LOGIN_BY_EMAIL)){
            String email = paramMap.get(EMAIL_ID);
            accountCount = accountRepository.countAccountByEmail(email);
        }else if(signUpType.equals(LOGIN_BY_MOBILE)){
            String mobileNumber = paramMap.get(MOBILE_NUIMBER);
            accountCount = accountRepository.countAccountByMobileNumber(mobileNumber);
        }

        return accountCount.flatMap( count ->
        {
            JSONObject jsonObject = new JSONObject();
            if(count > 0)
                jsonObject.put(STATUS, FAILED);
            else {
                jsonObject.put(STATUS, SUCCESS);
            }
            return Mono.just(updateResponse(this.getClass().getSimpleName(), eventData, jsonObject));
        });
    }

    public void doOnSuccess(String  count){
        System.out.println(count);
    }
    public void doOnError(Throwable error){
        System.out.println(error);
    }
}

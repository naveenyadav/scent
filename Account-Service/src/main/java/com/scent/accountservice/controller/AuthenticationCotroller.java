package com.scent.accountservice.controller;


import com.scent.accountservice.handler.CreateAccountHandler;
import com.scent.core.controller.BaseController;
import com.scent.core.data.EventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * This controller class file is used to handle following:
 * Purpose:
 * Methods:
 *
 * @author nyadav
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationCotroller extends BaseController {
    @Autowired
    private CreateAccountHandler createAccountHandler;
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void authLogin(@RequestBody Map<String, String> queryParams) {
        queryParams.put("", "");
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void authLogout(@RequestParam Map<String, String> queryParams) {
        queryParams.put("", "");
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> authSignUp(@RequestBody Map<String, String> queryParams) {
        EventData eventData = gerEventData(queryParams);
        return createAccountHandler.getresult(eventData).flatMap(responseData -> {
            return Mono.just(responseData.toString());
        });


    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void forgotPassword(@RequestBody Map<String, String> queryParams) {
        queryParams.put("", "");
    }
}


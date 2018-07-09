package com.scent.core.util;

import com.scent.core.data.RequestData;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import static com.scent.core.util.Constants.*;


public class CommonUtil {
    /**
     * no arg constructor
     */
    private CommonUtil() {
        super();
    }



    /**
        * Returns error message if any required field is missing in request data
     *
             * @param requestData
     *            the request data object
     * @param requiredFieldList
     *            the list of required field names
     * @return error message if any required field is missing in request data
     */
    public static String getErrorForRequiredFields(RequestData requestData, List<String> requiredFieldList) {

        if (null == requiredFieldList) {
            return EMPTY;
        }
        StringBuilder errorMessage = new StringBuilder();
        Map<String, String> parameterMap = requestData.getDataMap();

        for (String requiredFieldName : requiredFieldList) {
            if (StringUtil.isBlank(parameterMap.get(requiredFieldName))) {
                errorMessage.append(requiredFieldName).append(" is required, ");
            }
        }
        return errorMessage.toString();

    }



    /**
     * This method is used to create the error response object. The error
     * response contains error status and error details (if query parameters
     * contains getException).
     *
     * @param errorMessage
     *            the error message.
     * @param includeErrorDetails
     *            the flag to include error details.
     * @return errorResponse the error response object in JSON format.
     */
    public static JSONObject getErrorResponse(String errorMessage, String statusCode, boolean includeErrorDetails) throws JSONException {
        JSONObject errorResponse = new JSONObject();
        String errormessage = errorMessage;
        errorResponse.put(ERROR_STATUS_KEY, ERROR_STATUS_VALUE);
        if (includeErrorDetails && StringUtil.isNotBlank(errormessage)) {
            errormessage = errormessage.replaceAll(DOUBLE_QUOTE, EMPTY);
            errorResponse.put(EXCEPTION_TEXT, errormessage);
        }
        if(StringUtil.isNotBlank(statusCode)){
            errorResponse.put(JSON_STATUS_CODE, statusCode);
        }

        return errorResponse;
    }

    /**
     * This method is used to check if the service response contains error.
     *
     * @param jsonServiceResponse
     *            the service response
     * @return isSuccessResponse the boolean value
     */
    public static boolean isSuccessResponse(JSONObject jsonObject) {
        boolean isSuccessResponse = false;
        if (null == jsonObject) {
            isSuccessResponse = false;
        }else {
            if (jsonObject.has(STATUS) && jsonObject.get(STATUS).equals(SUCCESS)) {
                isSuccessResponse = true;
            }else if(jsonObject.has(ERROR_STATUS_KEY)){
                isSuccessResponse = false;
            }
        }

        return isSuccessResponse;
    }


}

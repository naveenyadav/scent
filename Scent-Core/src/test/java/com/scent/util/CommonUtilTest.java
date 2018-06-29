package com.scent.util;

import com.scent.core.metadata.TestMetaData;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static com.scent.core.util.CommonUtil.*;
import static com.scent.core.util.Constants.ERROR_STATUS_KEY;
import static com.scent.core.util.Constants.ERROR_STATUS_VALUE;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@TestMetaData
public class CommonUtilTest {
    @Test
    public void testIsSuccessResponse(){
        assertFalse(isSuccessResponse(null));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(ERROR_STATUS_KEY, ERROR_STATUS_VALUE);
        assertFalse(isSuccessResponse(jsonObject));
    }

}

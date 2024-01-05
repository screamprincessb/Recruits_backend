package com.sense.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sense.service.conts.RestCustomConst;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtil {

    public static ObjectMapper objMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper
                .setDateFormat(new SimpleDateFormat(RestCustomConst.REST_JACKSON_DATE_TIME_DESERIALIZER));
    }

    public static String obj2JsonStr(Object requestBody) {
        ObjectMapper objectMapper = new ObjectMapper();

        String str = null;
        try {
            str = objectMapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(JsonUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return str;
    }

    public static String responseObj2JsonStr(Object requestBody) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        TimeZone tz = TimeZone.getTimeZone("Asia/Bangkok");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(df);
        objectMapper.setTimeZone(tz);

        String str = null;
        try {
            str = objectMapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(JsonUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return str;
    }
}

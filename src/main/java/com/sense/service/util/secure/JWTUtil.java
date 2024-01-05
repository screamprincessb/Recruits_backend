package com.sense.service.util.secure;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sense.service.util.BackEndDateTimeUtil;
import com.sense.service.conts.RestCustomConst;
import io.jsonwebtoken.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class JWTUtil {

    private static final String SECRET_KEY = "uU7PaxV6d5upegC2m";

    public static String createJWT(String payLoad) throws UnsupportedEncodingException {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        String jws = Jwts.builder()
                .setPayload(payLoad)
                .signWith(
                        signatureAlgorithm,
                        SECRET_KEY.getBytes("UTF-8")
                )
                .compact();

        return jws;
    }

    public static AuthPayloadJWT decodeJWTData(String jwt) throws Exception {
        AuthPayloadJWT result = new AuthPayloadJWT();

        try {
            Claims claims = decodeJWT(jwt);
            result = mapData(claims);
        } catch (Exception ex) {
            throw ex;
        }

        return result;
    }

    public static String convertPayloadDataToJSONString(AuthPayloadJWT payload) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper
                .setDateFormat(new SimpleDateFormat(RestCustomConst.REST_JACKSON_DATE_TIME_DESERIALIZER))
                .writeValueAsString(payload);
    }

    public static AuthPayloadJWT convertJSONStringToPayloadData(String payloadJSON) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper
                .setDateFormat(new SimpleDateFormat(RestCustomConst.REST_JACKSON_DATE_TIME_DESERIALIZER))
                .readValue(payloadJSON, AuthPayloadJWT.class);
    }

    private static AuthPayloadJWT mapData(Claims claims) {
        AuthPayloadJWT result = new AuthPayloadJWT();

        String key;
        Object value;

        for (Map.Entry<String, Object> entry : claims.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();

            if (key.equals("apiKeyId")) {
                result.setApiKeyId(objToString(value));
            }

            if (key.equals("role")) {
                result.setRole(objToString(value));
            }

            if (key.equals("expireDt")) {
                result.setExpireDt(objToDt(value));
            }

            if (key.equals("createDt")) {
                result.setCreateDt(objToDt(value));
            }
            
            if (key.equals("userId")) {
                result.setUserId(objToString(value));
            }
            
            if (key.equals("password")) {
                result.setPassword(objToString(value));
            }
        }

        return result;
    }

    private static String objToString(Object obj) {
        String result = null;
        if (obj != null) {
            result = obj.toString();
        }

        return result;
    }

    private static Date objToDt(Object obj) {
        Date result = null;
        if (obj != null) {
            result = BackEndDateTimeUtil.convertString2DateTime(obj.toString(), BackEndDateTimeUtil.DATE_TIME_FORMAT_5);
        }

        return result;
    }

    private static Claims decodeJWT(String jwt) throws Exception {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY.getBytes("UTF-8"))
                    .parseClaimsJws(jwt).getBody();
        } catch (Exception ex) {
            throw ex;
        }

        return claims;
    }

}

package com.sense.service.util.secure;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestApp {

    public static void main(String[] args) {
        String s0 = "eyJhbGciOiJIUzI1NiJ9.ewogICJ1c2VyIjogImEiLCJwYXNzd29yZCI6ICJwcCIKfQ.J7fo8cy3qkqW7WUhLTTOQs_4AFskEJeLLNY381f0Dx4";
        String in = "{\n"
                + "  \"apiKeyId\": \"key-1\",\n"
                + "  \"desc\": \"Desc\",\n"
                + "  \"role\": \"USER,ADMIN\",\n"
                + "  \"expireDt\": \"2024-01-01 00:00:00.000\",\n"
                + "  \"remark\": \"Remark\",\n"
                + "  \"createDt\": \"2024-01-01 00:00:00.000\",\n"
                + "  \"createBy\": \"WLMA\"\n"
                + "}";
        String s1 = null;
        try {
            s1 = JWTUtil.createJWT(in);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TestApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(s1);

        //s1 = "eyJhbGciOiJIUzI1NiJ9.ewogICJhcGlLZXlJZCI6ICJrZXktMSIsCiAgImRlc2MiOiAiRGVzYyIsCiAgInJvbGUiOiAiVVNFUixBRE1JTiIsCiAgImV4cGlyZUR0IjogIjIwMjMtMDEtMDEgMDA6MDA6MDAuMDAwIiwKICAicmVtYXJrIjogIlJlbWFyayIsCiAgImNyZWF0ZUR0IjogIjIwMjQtMDEtMDEgMDA6MDA6MDAuMDAwIiwKICAiY3JlYXRlQnkiOiAiV0xNQSIKfQ.L_Bhl8JpS5ALjjs40NiIje7VmkH4b0d5WdKxjytFcXw";
        try {
            AuthPayloadJWT data = JWTUtil.decodeJWTData(s1);
            System.out.println(JWTUtil.convertPayloadDataToJSONString(data));
            
        } catch (Exception ex) {
            Logger.getLogger(TestApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

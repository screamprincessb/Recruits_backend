package com.sense.service.util.secure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sense.service.util.DateTimeUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test2App {
    public static void main(String[] args) {
        AuthPayloadJWT input = new AuthPayloadJWT();
        input.setApiKeyId("key-1");
        input.setDesc("WLMA");
        input.setRole("USER,ADMIN");
        input.setCreateDt(DateTimeUtil.getSystemDate());
        input.setExpireDt(DateTimeUtil.stringToDateDB("2024-01-01 00:00:00"));
        input.setRemark("Remark");
        input.setCreateBy("WLMA");
        
        try {
            String s = JWTUtil.convertPayloadDataToJSONString(input);
            System.out.println(s);
            AuthPayloadJWT output = JWTUtil.convertJSONStringToPayloadData(s);
            System.out.println("");
            System.out.println(output.getApiKeyId());
            System.out.println(output.getExpireDt());
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Test2App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Test2App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

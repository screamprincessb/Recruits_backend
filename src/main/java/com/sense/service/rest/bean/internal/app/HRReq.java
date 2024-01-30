/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author SenseInfoTech
 */
@ToString
@Data
public class HRReq implements Serializable {
    private HRData data;
    
    @Data
    public class HRData {
        private Integer hrId;
        private String hrTitleName;
        private String hrFirstName;
        private String hrLastName;
        private String hrPosition;
        private String hrPhone;
        private String hrEmail;
        private String hrUser;
        private String hrPassword;
//        private Date hrCreateDT;
        private String hrCreateBy;
//        private Date hrUpdateDT;
        private String hrUpdateBy;
        private String hrDeleteFlag;
    }
}

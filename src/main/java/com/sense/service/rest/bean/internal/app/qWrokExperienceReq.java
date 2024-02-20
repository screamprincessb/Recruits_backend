/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author SenseInfoTech
 */
@ToString
@Data
public class qWrokExperienceReq implements Serializable{
    
    private qWorkExperienceData data;
    
    @Data
    public class qWorkExperienceData{
    private String workExperienceId;
//    private Date weStartDT;
//    private Date weEndDT;
    private String weBusinessType;
    private String weName;
    private String wePosition;
    private String weOtherBenefit;
    private float weSalary;
    private String weAddressPhone;
    private String weDescription;
    private String weReasonLeaving;
    private String applicationId;
    private String refFirstName;
    private String refLastName;
    private String refJobPosition;
    private String refWorkLocation;
    private String refPhone;
    }

}

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
public class qInterviewAppointmentReq implements Serializable {
    private qInterviewAppointmentData data;
    
    @Data
    public class qInterviewAppointmentData{
    private Integer interAppId;
    private String canFirstNameTH;
    private String canLastNameTH;
    private String positionName;
    private String hrFirstName;
    private String hrLastName;
//    private Date inteAppDT;
//    private Date inteAppTime;
//    private Date inteAppTimeTo;
    private String interAppLocation;
    private String interAppStatus;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author SenseInfoTech
 */
@ToString
@Data
public class InterviewAppointmentReq {

    private InterviewAppointmentData data;

    @Data
    public class InterviewAppointmentData {

        private String interAppId;
//        private Date inteAppDT;
//        private Date inteAppTime;
//        private Date inteAppTimeTo;
        private String interAppLocation;
        private String interAppStatus;
//        private Date interAppCreateDT;
        private String interAppCreateby;
//        private Date interAppUpdateDT;
        private String interAppUpdateby;
        private String interAppDelete;
        private String interviewId;
    }
}

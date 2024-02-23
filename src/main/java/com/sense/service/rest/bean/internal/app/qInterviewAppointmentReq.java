/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.service.rest.bean.internal.app;

import jakarta.persistence.Entity;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
public class qInterviewAppointmentReq implements Serializable {

    private qInterviewAppointmentData data;

    @Data
    public class qInterviewAppointmentData {

        private String interviewId;
//    private Date interviewDT;
//    private Date interviewTime;
        private String interviewResult;
        private String interviewNote;
        private String interviewStatus;
        private String interviewLocation;
//    private Date interviewCreateDT;
        private String interviewCreateby;
//    private Date interviewUpdateDT;
        private String interviewUpdateby;
        private String interviewDelete;
        private String applicationId;
        private String canFirstNameTH;
        private String canLastNameTH;
        private String hrId;
        private String hrFirstName;
        private String hrLastName;
        private String positionId;
        private String positionName;
    }

}

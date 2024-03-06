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
public class qEmailCandidateInfoReq implements Serializable {

    private qEmailCandidateInfoData data;

    @Data
    public class qEmailCandidateInfoData {

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
        private String hrId;
        private String canFirstNameTH;
        private String canLastNameTH;
        private String contactEmail;
        private String hrFirstName;
        private String hrLastName;
        private String hrPosition;
        private String hrEmail;
        private String positionId;
        private String positionName;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
public class qInterviewAppointmentEntity {
    
    @Id
    @Column(name = "INTERVIEW_ID")
    private String interviewId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INTERVIEW_DATE")
    private Date interviewDT;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INTERVIEW_TIME")
    private Date interviewTime;

    @Column(name = "INTERVIEW_RESULT")
    private String interviewResult;

    @Column(name = "INTERVIEW_NOTE")
    private String interviewNote;

    @Column(name = "INTERVIEW_STATUS")
    private String interviewStatus;
    
    @Column(name = "INTERVIEW_LOCATION")
    private String interviewLocation;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INTERVIEW_CREATE_DATE")
    private Date interviewCreateDT;
    
    @Column(name = "INTERVIEW_CREATE_BY")
    private String interviewCreateby;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INTERVIEW_UPDATE_DATE")
    private Date interviewUpdateDT;
    
    @Column(name = "INTERVIEW_UPDATE_BY")
    private String interviewUpdateby;
    
    @Column(name = "INTERVIEW_DELETE")
    private String interviewDelete;

    @Column(name = "APPLICATION_ID")
    private String applicationId;

    @Column(name = "INTERVIEWER_ID")
    private String interviewerId;

    @Column(name = "CAN_FIRST_NAME_TH")
    private String canFirstNameTH;

    @Column(name = "CAN_LAST_NAME_TH")
    private String canLastNameTH;
    
    @Column(name = "HR_ID")
    private String hrId;
    
    @Column(name = "HR_FIRST_NAME")
    private String hrFirstName;
    
    @Column(name = "HR_LAST_NAME")
    private String hrLastName;
    
    @Column(name = "POSITION_ID")
    private String positionId;

    @Column(name = "POSITION_NAME")
    private String positionName;
}

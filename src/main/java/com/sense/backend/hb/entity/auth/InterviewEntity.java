/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
@Table(name = "INTERVIEW")
public class InterviewEntity implements Serializable {

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

}

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
@Table(name = "INTERVIEW_APPOINTMENT")
public class InterviewAppointmentEntity implements Serializable{
     
    @Id
    @Column(name = "INTER_APP_ID")
    private String interAppId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INTER_APP_DATE")
    private Date inteAppDT;
    
    @Temporal(TemporalType.TIMESTAMP)    
    @Column(name = "INTER_APP_TIME")
    private Date inteAppTime;
    
    @Temporal(TemporalType.TIMESTAMP)    
    @Column(name = "INTER_APP_TIME_TO")
    private Date inteAppTimeTo;
    
    @Column(name = "INTER_APP_LOCATION")
    private String interAppLocation;
    
    @Column(name = "INTER_APP_STATUS")
    private String interAppStatus;
    private Date interAppCreateDT;
    
    @Column(name = "INTER_APP_CREATE_BY")
    private String interAppCreateby;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INTER_APP_UPDATE_DATE")
    private Date interAppUpdateDT;
    
    @Column(name = "INTER_APP_UPDATE_BY")
    private String interAppUpdateby;
    
    @Column(name = "INTER_APP_DELETE")
    private String interAppDelete;
    
    @Column (name = "INTERVIEW_ID")
    private String interviewId;
    
}

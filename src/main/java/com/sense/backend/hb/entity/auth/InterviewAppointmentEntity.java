/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    private int interAppId;
    
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
    private char interAppStatus;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INTER_APP_CREATE_DATE")
    private Date interAppCreateDT;
    
    @Column(name = "INTER_APP_CREATE_BY")
    private String interAppCreateby;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INTER_APP_UPDATE_DATE")
    private Date interAppUpdateDT;
    
    @Column(name = "INTER_APP_UPDATE_BY")
    private String interAppUpdateby;
    
    @Column(name = "INTER_APP_DELETE_FLAG")
    private String interAppDeleteFlag;
    
}

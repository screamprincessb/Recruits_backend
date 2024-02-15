/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "Q_INTERVIEW_APPOINTMENT")
public class qInterviewAppointmentEntityToJoin {
    @Id
    @Column(name = "INTER_APP_ID")
    private Integer interAppId;
    
    @Column(name = "CAN_FIRST_NAME_TH")
    private String canFirstNameTH;
    
    @Column(name = "CAN_LAST_NAME_TH")
    private String canLastNameTH;
    
    @Column(name = "POSITION_NAME")
    private String positionName;
    
    @Column(name = "HR_FIRST_NAME")
    private String hrFirstName;
    
    @Column(name = "HR_LAST_NAME")
    private String hrLastName;
    
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
    
}

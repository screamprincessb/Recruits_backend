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
@Table(name = "INTERVIEW")
public class InterviewEntity implements Serializable{
    
    @Id
    @Column(name = "INTERVIEW_ID")
    private int interviewId;
    
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
    private char interviewStatus;
    
    
}

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
public class InterviewEntity implements Serializable{
    
    @Id
    @Column(name = "INTERVIEW_ID")
    private Integer interviewId;
    
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
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
@Table(name = "INTERVIEWER")
public class InterviewerEntity implements Serializable{
    
    @Id
    @Column(name = "INTERVIEWER_ID")
    private int interviewerId;
    
    @Column(name = "INTERVIEWER_STATUS")
     private String interviewerStatus;
    
//    @ManyToOne
//    @JoinColumn(name = "HR_ID", referencedColumnName = "HR_ID")
//    private HREntity hr;
}

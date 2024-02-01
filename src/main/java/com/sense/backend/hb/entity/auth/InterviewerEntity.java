/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author SenseInfoTech
 */
@Data
@Entity
@Table(name = "INTERVIEWER")
public class InterviewerEntity implements Serializable {

    @Id
    @Column(name = "INTERVIEWER_ID")
    private Integer interviewerId;

    @Column(name = "INTERVIEWER_STATUS")
    private String interviewerStatus;

    @Column(name = "HR_ID")
    private Integer hrId;

//    @ManyToOne
//    @JoinColumn(name = "HR_ID", referencedColumnName = "HR_ID")
//    private HREntity hr;
}

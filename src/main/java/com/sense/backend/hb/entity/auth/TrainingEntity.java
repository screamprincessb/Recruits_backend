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
@Table(name = "TRAINING")
public class TrainingEntity implements Serializable{
    
    @Id
    @Column(name = "TRAINING_ID")
    private int trainingId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRAINING_DATE")
    private Date trainingDate;
    
    @Column(name = "TRAINING_COURSE")
    private String trainingCourse;
    
    @Column(name = "TRAINING_INSTITUTION")
    private String trainingInstitution;
    
    @Column(name = "TRAINING_QUALIFICATION")
    private String trainingQualification;
    
    @Column(name = "TRAINING_TIME")
    private String trainingTime;
    
   
}

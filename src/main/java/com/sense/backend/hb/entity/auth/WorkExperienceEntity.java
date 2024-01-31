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
@Table(name = "WORK_EXPERIENCE")
public class WorkExperienceEntity implements Serializable{
    
    @Id
    @Column(name = "WORK_EXPERIENCE_ID")
    private Integer workExperienceId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "WE_START_DATE")
    private Date weStartDT;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "WE_END_DATE")
    private Date weEndDT;
    
    @Column(name = "WE_BUSINES_TYPE")
    private String weBusinessType;
    
    @Column(name = "WE_NAME")
    private String weName;
    
    @Column(name = "WE_POSITION")
    private String wePosition;
    
    @Column(name = "WE_MAJOR")
    private String weMajor;
    
    @Column(name = "WE_SALARY")
    private float weSalary;
    
    @Column(name = "WE_ADDRESS_PHONE")
    private String weAddressPhone;
    
    @Column(name = "WE_DESCRIPTION")
    private String weDescription;
    
    @Column(name = "WE_REASON_LEAVING")
    private String weReasonLeaving;
    
    
}

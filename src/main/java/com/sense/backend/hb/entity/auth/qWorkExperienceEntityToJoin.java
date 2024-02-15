/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.entity.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class qWorkExperienceEntityToJoin {

    @Id
    @Column(name = "WORK_EXPERIENCE_ID")
    private Integer workExperienceId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "WE_START_DATE")
    private Date weStartDT;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "WE_END_DATE")
    private Date weEndDT;

    @Column(name = "WE_BUSINESS_TYPE")
    private String weBusinessType;

    @Column(name = "WE_NAME")
    private String weName;

    @Column(name = "WE_POSITION")
    private String wePosition;

    @Column(name = "WE_OTHER_BENEFIT")
    private String weOtherBenefit;

    @Column(name = "WE_SALARY")
    private float weSalary;

    @Column(name = "WE_ADDRESS_PHONE")
    private String weAddressPhone;

    @Column(name = "WE_DESCRIPTION")
    private String weDescription;

    @Column(name = "APPLICATION_ID")
    private Integer applicationId;

    @Column(name = "WE_REASON_LEAVING")
    private String weReasonLeaving;

    @Column(name = "REF_FIRST_NAME")
    private String refFirstName;

    @Column(name = "REF_LAST_NAME")
    private String refLastName;

    @Column(name = "REF_JOB_POSITION")
    private String refJobPosition;

    @Column(name = "REF_WORK_LOCATION")
    private String refWorkLocation;

    @Column(name = "REF_PHONE")
    private String refPhone;
}
